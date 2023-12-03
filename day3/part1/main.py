all_possible_numbers = ['1','2','3','4','5','6','7','8','9','0']

def getDataTables():
    data_file = open("data.txt", "r+")
    data_table = []
    data_string_table = []
    data_numbers_table = []

    for line in data_file.readlines():
        data_string_table.append(line)
        current_row = []
        current_numbers_row = []
        current_number = ''
        for character in line:
            current_row.append(character)
            if character in all_possible_numbers:
                current_number += character
            elif current_number !=  '':
                current_numbers_row.append(current_number)
                current_number = ''
        data_table.append(current_row)
        data_numbers_table.append(current_numbers_row)

    data_file.close()
    
    return data_table, data_string_table, data_numbers_table

def isSymbol(character):
    return character not in all_possible_numbers and character != '.'

def isNumberSchematic(target_indexes, row_index, data_table, num_temp):
    row_length = len(data_table[row_index])-1
    for index in target_indexes:      
        # Check horizontally
        if index != 0:
            left_char = data_table[row_index][index - 1]
            if isSymbol(left_char): return True
        if index != row_length-1:
            right_char = data_table[row_index][index + 1]
            if isSymbol(right_char): return True

        # Check top
        if row_index > 0:
            top_char = data_table[row_index-1][index]
            if isSymbol(top_char): return True
            # Check diagonales top
            if index != 0:
                top_left_char = data_table[row_index-1][index-1]
                if isSymbol(top_left_char): return True  
            if index != row_length-1:
                top_right_char = data_table[row_index-1][index+1]
                if isSymbol(top_right_char): return True
                
        # Check bottom
        if row_index < len(data_table)-1:
            bottom_char = data_table[row_index+1][index]
            if isSymbol(bottom_char): return True
            # Check diagonales bottom
            if index != 0:
                bottom_left_char = data_table[row_index+1][index-1]
                if isSymbol(bottom_left_char): return True  
            if index != row_length-1:
                bottom_right_char = data_table[row_index+1][index+1]
                if isSymbol(bottom_right_char): return True
    
    return False

def getSumFromList(num_list):
    counter = 0
    for num in num_list:
        counter+= num
        
    return counter
    
def main():
    data_table, data_string_table, data_numbers_table = getDataTables()
    all_schematic_numbers = []
    index = 0
    while index != len(data_table):
        current_numbers = data_numbers_table[index]
        current_string = data_string_table[index]
        index_string = 0
        for num in current_numbers:
            targetIndexes = []
            currentTargetIndex = current_string.index(num, index_string)
            for char in num:
                targetIndexes.append(currentTargetIndex)
                currentTargetIndex+=1
            if isNumberSchematic(targetIndexes, index, data_table, num):
                all_schematic_numbers.append(int(num))
            index_string = currentTargetIndex
        index+=1
    print(getSumFromList(all_schematic_numbers))
    

if __name__ == "__main__":
    main()