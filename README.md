# Card-game
Besikovitch’s game is for two players. You are one ("The human"), your program is the other ("The computer")

Each player gets one suit from a pack of playing cards.  It doesn’t matter which suit, we’re only interested in the numbers. Ace is 1, 2 is 2, ... up to king is 13.

A third suit is shuffled by you (the Human, NOT by your program). The fourth suit isn’t used.

The game consists of 13 rounds. Each round:

The top card of the third suit is revealed. This is the “stake” card.
Each player secretly chooses a card from their own suit to bid for the stake card.
They reveal these simultaneously.
High card wins the stake card. This goes into their victory pile. If it’s a draw, no-one wins it and it’s removed from play.
Both bid cards are removed from play regardless.
At the end of the 13th round, players add up the total values of the stake cards they have won. Highest total wins the game. If it’s the same, the game is drawn.
