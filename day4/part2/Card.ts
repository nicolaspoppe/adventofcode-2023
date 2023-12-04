export class Card {
  private id: number;
  private winnerNumbers: number[];
  private drawnNumbers: number[];

  constructor(cardString: string) {
    const cardStringFirstSplit = cardString.split(":");
    this.id = this.getCardId(cardStringFirstSplit[0]);

    const cardStringSecondSplit = cardStringFirstSplit[1].split("|");
    this.winnerNumbers = this.getNumbersFromString(cardStringSecondSplit[0]);
    this.drawnNumbers = this.getNumbersFromString(cardStringSecondSplit[1]);
  }

  /**
   * Returns the id of the string card given.
   *
   * @remarks
   * The cardString element must be something like 'Card 51'
   *
   */
  private getCardId(cardString: string) {
    const stringToDelete = "Card ";

    return parseInt(cardString.slice(stringToDelete.length - 1));
  }

  public getId() {
    return this.id;
  }

  /**
   * Returns a list of number corresponding of the numbers given in the string.
   *
   * @remarks
   * The numbersString element must be something like '74 23 73 99 60 87 45 75 70 85'
   *
   */
  private getNumbersFromString = (numbersString: string) =>
    numbersString
      .split(" ")
      .filter((stringNumber: string) => stringNumber !== "")
      .map((stringNumber: string) => parseInt(stringNumber));

  getPoints() {
    let points = 0;
    this.winnerNumbers.forEach((winnerNumber: number) => {
      if (
        this.drawnNumbers.find(
          (drawnNumber: number) => drawnNumber === winnerNumber
        )
      ) {
        points = points == 0 ? 1 : points * 2;
      }
    });

    return points;
  }

  getDuplicatesId() {
    let duplicates = 0;
    const duplicatesList: number[] = [];
    this.winnerNumbers.forEach((winnerNumber: number) => {
      if (
        this.drawnNumbers.find(
          (drawnNumber: number) => drawnNumber === winnerNumber
        )
      ) {
        duplicates++;
        const newId = this.id + duplicates;
        duplicatesList.push(newId);
      }
    });

    return duplicatesList.reverse();
  }
}
