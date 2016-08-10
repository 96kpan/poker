
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Tests the CardHand class, last modified August 2015
 * 
 * I think this a pretty good unit test, if you add any please send them to me!
 */
public class PokerHandTest {

  // Set up 52 cards so we can use C2 instead of new Card(Rank.Deuce,
  // Suit.Clubs)
  private final static Card C2 = new Card(Rank.Deuce, Suit.Clubs);
  private final static Card C3 = new Card(Rank.Three, Suit.Clubs);
  private final static Card C4 = new Card(Rank.Four, Suit.Clubs);
  private final static Card C5 = new Card(Rank.Five, Suit.Clubs);
  private final static Card C6 = new Card(Rank.Six, Suit.Clubs);
  private final static Card C7 = new Card(Rank.Seven, Suit.Clubs);
  private final static Card C8 = new Card(Rank.Eight, Suit.Clubs);
  private final static Card C9 = new Card(Rank.Nine, Suit.Clubs);
  private final static Card C10 = new Card(Rank.Ten, Suit.Clubs);
  private final static Card CJ = new Card(Rank.Jack, Suit.Clubs);
  private final static Card CQ = new Card(Rank.Queen, Suit.Clubs);
  private final static Card CK = new Card(Rank.King, Suit.Clubs);
  private final static Card CA = new Card(Rank.Ace, Suit.Clubs);

  private final static Card D2 = new Card(Rank.Deuce, Suit.Diamonds);
  private final static Card D3 = new Card(Rank.Three, Suit.Diamonds);
  private final static Card D4 = new Card(Rank.Four, Suit.Diamonds);
  private final static Card D5 = new Card(Rank.Five, Suit.Diamonds);
  private final static Card D6 = new Card(Rank.Six, Suit.Diamonds);
  private final static Card D7 = new Card(Rank.Seven, Suit.Diamonds);
  private final static Card D8 = new Card(Rank.Eight, Suit.Diamonds);
  private final static Card D9 = new Card(Rank.Nine, Suit.Diamonds);
  private final static Card D10 = new Card(Rank.Ten, Suit.Diamonds);
  private final static Card DJ = new Card(Rank.Jack, Suit.Diamonds);
  private final static Card DQ = new Card(Rank.Queen, Suit.Diamonds);
  private final static Card DK = new Card(Rank.King, Suit.Diamonds);
  private final static Card DA = new Card(Rank.Ace, Suit.Diamonds);

  private final static Card H2 = new Card(Rank.Deuce, Suit.Hearts);
  private final static Card H3 = new Card(Rank.Three, Suit.Hearts);
  private final static Card H4 = new Card(Rank.Four, Suit.Hearts);
  private final static Card H5 = new Card(Rank.Five, Suit.Hearts);
  private final static Card H6 = new Card(Rank.Six, Suit.Hearts);
  private final static Card H7 = new Card(Rank.Seven, Suit.Hearts);
  private final static Card H8 = new Card(Rank.Eight, Suit.Hearts);
  private final static Card H9 = new Card(Rank.Nine, Suit.Hearts);
  private final static Card H10 = new Card(Rank.Ten, Suit.Hearts);
  private final static Card HJ = new Card(Rank.Jack, Suit.Hearts);
  private final static Card HQ = new Card(Rank.Queen, Suit.Hearts);
  private final static Card HK = new Card(Rank.King, Suit.Hearts);
  private final static Card HA = new Card(Rank.Ace, Suit.Hearts);

  private final static Card S2 = new Card(Rank.Deuce, Suit.Spades);
  private final static Card S3 = new Card(Rank.Three, Suit.Spades);
  private final static Card S4 = new Card(Rank.Four, Suit.Spades);
  private final static Card S5 = new Card(Rank.Five, Suit.Spades);
  private final static Card S6 = new Card(Rank.Six, Suit.Spades);
  private final static Card S7 = new Card(Rank.Seven, Suit.Spades);
  private final static Card S8 = new Card(Rank.Eight, Suit.Spades);
  private final static Card S9 = new Card(Rank.Nine, Suit.Spades);
  private final static Card S10 = new Card(Rank.Ten, Suit.Spades);
  private final static Card SJ = new Card(Rank.Jack, Suit.Spades);
  private final static Card SQ = new Card(Rank.Queen, Suit.Spades);
  private final static Card SK = new Card(Rank.King, Suit.Spades);
  private final static Card SA = new Card(Rank.Ace, Suit.Spades);

  @Test
  public void testHighCard1() {
    PokerHand a = new PokerHand(C3, C4, D6, D7, DA);
    PokerHand b = new PokerHand(C2, C5, C7, DQ, DK);
    assertTrue(a.compareTo(b) > 0);
  }

  @Test
  public void testHighCard2() {
    PokerHand a = new PokerHand(C3, C4, D6, D7, DQ);
    PokerHand b = new PokerHand(C2, C5, C7, DJ, DK);
    assertTrue(a.compareTo(b) < 0);
  }

  @Test
  public void testHighCard3() {
    PokerHand a = new PokerHand(C3, C4, C6, CJ, DK);
    PokerHand b = new PokerHand(D2, D5, D7, DJ, SK);
    assertTrue(b.compareTo(a) > 0);
  }

  @Test
  public void testHighCard4() {
    PokerHand a = new PokerHand(C3, C4, C7, CJ, DK);
    PokerHand b = new PokerHand(D2, D5, D7, DJ, SK);
    assertTrue(b.compareTo(a) > 0);
  }

  @Test
  public void testHighCard5() {
    PokerHand a = new PokerHand(C3, C5, C7, CJ, DK);
    PokerHand b = new PokerHand(D2, D5, D7, DJ, SK);
    assertTrue(b.compareTo(a) < 0);
  }

  @Test
  public void testPair1() {
    PokerHand a = new PokerHand(C3, C4, C7, CJ, DJ);
    PokerHand b = new PokerHand(D2, D5, D7, D10, S10);
    assertTrue(a.compareTo(b) > 0);
  }

  @Test
  public void testPair3() {
    PokerHand a = new PokerHand(CA, CK, CQ, C5, D5);
    PokerHand b = new PokerHand(DQ, DK, DA, D6, S6);
    assertTrue(a.compareTo(b) < 0);
  }

  @Test
  public void testPair13() { // do I have some of these pair tests below?
    PokerHand a = new PokerHand(CA, CK, CQ, C5, D5);
    PokerHand b = new PokerHand(DQ, DK, DA, D4, S4);
    assertTrue(a.compareTo(b) > 0);
  }

  @Test
  public void testPairWhenTied() {
    PokerHand a = new PokerHand(H3, CA, D4, H6, SA);
    PokerHand b = new PokerHand(D3, C4, DA, HA, C6);
    assertTrue(a.compareTo(b) <= 0);
    assertTrue(b.compareTo(a) >= 0);
  }

  @Test
  public void testTwoPair() {
    PokerHand a = new PokerHand(C4, CA, D4, H3, DA);
    PokerHand b = new PokerHand(H4, C10, HA, SA, S4);
    assertTrue(a.compareTo(b) < 0);
    assertTrue(b.compareTo(a) > 0);
    assertTrue(a.compareTo(b) <= 0);
    assertTrue(b.compareTo(a) >= 0);

  }

  @Test
  public void testTwoPairWhenOnePairIsEqual() {
    PokerHand a = new PokerHand(C4, HK, D4, H3, DK);
    PokerHand b = new PokerHand(H4, C10, CA, DA, S4);
    assertTrue(a.compareTo(b) < 0);
    assertTrue(b.compareTo(a) > 0);
  }

  @Test
  public void testTwoPairWhenOnePairIsEqual2() {
    PokerHand a = new PokerHand(C8, D8, CA, SA, CK);
    PokerHand b = new PokerHand(H9, S9, HA, DA, HK); // 2 ACES, 2 FOURS
    assertTrue(a.compareTo(b) < 0);
    assertTrue(b.compareTo(a) > 0);
  }

  @Test
  public void testTwoPairWhenOnePairIsEqual3() {
    PokerHand a = new PokerHand(C9, D9, CK, DA, C2);
    PokerHand b = new PokerHand(H9, S9, HK, SA, C3);
    assertTrue(a.compareTo(b) < 0);
    assertTrue(b.compareTo(a) > 0);
    assertTrue(a.compareTo(b) != 0);
    assertTrue(b.compareTo(a) != 0);
  }

  @Test
  public void testTwoPairWhenTwoPairsAreEqual4() {
    PokerHand a = new PokerHand(C2, D2, C5, D5, CJ);
    PokerHand b = new PokerHand(H2, S2, H5, S5, C10);
    assertTrue(a.compareTo(b) > 0);
    assertTrue(b.compareTo(a) < 0);
  }

  @Test
  public void testTwoPairWhenTwoPairsAreEquaAndTheFifthCardHasSameRank() {
    PokerHand a = new PokerHand(C2, D2, C5, D5, CJ);
    PokerHand b = new PokerHand(H2, S2, H5, S5, SJ);
    assertTrue(a.compareTo(b) == 0);
    assertTrue(b.compareTo(a) == 0);
  }

  @Test
  public void testTwoPairWhenAtIndexesForCodeCoverage() {
    PokerHand a = new PokerHand(C2, D3, C5, D5, CJ);
    PokerHand b = new PokerHand(H2, S3, H3, S5, SJ);
    assertTrue(a.compareTo(b) > 0);
    assertTrue(b.compareTo(a) < 0);
  }

  @Test
  public void testTwoPair6() {
    PokerHand a = new PokerHand(C2, C5, D2, D5, CJ);
    PokerHand b = new PokerHand(H5, S5, H2, S2, C10);
    assertTrue(a.compareTo(b) > 0);
    assertTrue(b.compareTo(a) < 0);
  }

  // Trips
  @Test
  public void testTrips1() {
    PokerHand a = new PokerHand(H7, C7, D7, S9, S10);
    PokerHand b = new PokerHand(H9, C10, H6, C6, D6);
    assertTrue(a.compareTo(b) > 0);
    assertTrue(b.compareTo(a) < 0);
  }

  @Test
  public void testTrips2() {
    PokerHand a = new PokerHand(CK, DK, HK, CQ, CJ);
    PokerHand b = new PokerHand(CA, DA, HA, H2, D2);
    assertTrue(a.compareTo(b) < 0);
    assertTrue(b.compareTo(a) > 0);
  }

  @Test
  public void testTripsBeatsTwoPair() {
    PokerHand a = new PokerHand(C2, H2, S2, CQ, CJ);
    PokerHand b = new PokerHand(CA, DA, HK, SK, D2);
    assertTrue(a.compareTo(b) > 0);

  }

  @Test
  public void testTripsLosesToFourOfAKind() {
    PokerHand a = new PokerHand(CA, HA, SA, CQ, CJ);
    PokerHand b = new PokerHand(C2, D2, H2, S2, D8);
    assertTrue(a.compareTo(b) < 0);
  }

  @Test
  public void testFullHouse1() {
    PokerHand a = new PokerHand(H8, C8, D8, H4, C4);
    PokerHand b = new PokerHand(H7, C7, D7, S4, D4);
    assertTrue(a.compareTo(b) > 0);
    assertTrue(b.compareTo(a) < 0);
  }

  @Test
  public void testFullHouse2() {
    PokerHand a = new PokerHand(H3, C3, D3, C4, D4);
    PokerHand b = new PokerHand(H5, C5, D5, H4, S4);
    assertTrue(a.compareTo(b) < 0);
    assertTrue(b.compareTo(a) > 0);
    assertTrue(a.compareTo(b) <= 0);
    assertTrue(b.compareTo(a) >= 0);
  }

  @Test
  public void testFullHouse8() {
    PokerHand a = new PokerHand(H8, C8, D8, H4, C4);
    PokerHand b = new PokerHand(H7, C7, D7, S4, D4);
    assertTrue(a.compareTo(b) > 0);
    assertTrue(b.compareTo(a) < 0);
  }

  @Test
  public void testFullHouseWhenPairsAreEqual() {
    PokerHand a = new PokerHand(C2, D2, C3, D3, H3);
    PokerHand b = new PokerHand(H2, S2, C4, D4, H4);
    assertTrue(a.compareTo(b) < 0);
    assertTrue(b.compareTo(a) > 0);
  }

  @Test
  public void testFullHouseWhenPairIsGreaterThanTripsInOtherHandl() {
    PokerHand a = new PokerHand(C8, D8, C3, D3, H3);
    PokerHand b = new PokerHand(H7, S7, C4, D4, H4);
    assertTrue(b.compareTo(a) > 0);
    assertTrue(a.compareTo(b) < 0);
  }

  @Test
  public void testAceLowStraight() {
    PokerHand a = new PokerHand(CA, C2, C3, C4, H5);
    PokerHand b = new PokerHand(D2, D3, D4, D5, H6);
    boolean answer = a.compareTo(b) < 0;
    assertTrue(answer);
  }

  @Test
  public void testFourOfKindWhenLast4Match() {
    PokerHand a = new PokerHand(CA, C2, D2, H2, S2);
    PokerHand b = new PokerHand(DA, C3, D3, H3, S3);
    b.toString();
    assertTrue(a.compareTo(b) < 0);
  }

  @Test
  public void compareFlushes() {
    PokerHand a = new PokerHand(CA, C4, C6, C8, C9);
    PokerHand b = new PokerHand(HA, H4, H6, H8, H9);
    b.toString();
    assertTrue(a.compareTo(b) == 0);
  }

  // TEST CARD HGH HANDS

  private static PokerHand nothing72 = new PokerHand(C2, C3, C4, C5, D7);
  private static PokerHand nothing73 = new PokerHand(D2, D4, D5, D6, C7);
  private static PokerHand nothingJ = new PokerHand(C8, C9, C10, SJ, D3);
  private static PokerHand nothingK9 = new PokerHand(CK, CQ, CJ, D10, H9);
  private static PokerHand nothingK8 = new PokerHand(HK, HQ, HJ, H10, S8);
  private static PokerHand nothingA = new PokerHand(S9, SJ, SQ, SK, CA);

  @Test
  public void testNothing0() {
    assertTrue(nothing73.compareTo(nothing72) > 0);
  }

  @Test
  public void testNothing1() {
    assertTrue(nothingJ.compareTo(nothing73) > 0);
  }

  @Test
  public void testNothing2() {
    assertTrue(nothingK8.compareTo(nothingJ) > 0);
  }

  @Test
  public void testNothing3() {
    assertTrue(nothingK9.compareTo(nothingK8) > 0);
  }

  @Test
  public void testNothing4() {
    assertTrue(nothingA.compareTo(nothingK8) > 0);
  }

  // TEST PAIRS
  private static PokerHand pair = new PokerHand(D2, H2, D3, S7, H6);
  private static PokerHand pair2 = new PokerHand(C2, S2, CQ, CK, CA);
  private static PokerHand pair3 = new PokerHand(C3, H3, H4, H5, S6);
  private static PokerHand pairLow = new PokerHand(C2, D2, C3, H4, H5);
  private static PokerHand pairHigh = new PokerHand(HA, CA, CK, CQ, HJ);

  @Test
  public void testPair9() {
    assertTrue(pair2.compareTo(pair) > 0);
  }

  @Test
  public void testPair4() {
    assertTrue(pair3.compareTo(pair) > 0);
    System.out.println(pair + " < " + pair3);

  }

  @Test
  public void testPair5() {
    assertTrue(pairHigh.compareTo(pairLow) > 0);
  }

  @Test
  public void testPair6() {
    assertTrue(pairHigh.compareTo(pair) > 0);
  }

  @Test
  public void testPair7() {
    assertTrue(pairHigh.compareTo(nothingJ) > 0);
  }

  @Test
  public void testPair8() {
    assertTrue(pairHigh.compareTo(nothingJ) > 0);
  }

  @Test
  public void testPair10() {
    assertTrue(pair.compareTo(nothingA) > 0);
  }

  // Test two pairs
  private static PokerHand twoPair = new PokerHand(D2, S4, C3, C2, H3);
  private static PokerHand twoPair2 = new PokerHand(H9, D9, S2, H2, SJ);
  private static PokerHand twoPairA = new PokerHand(DA, CA, DK, CK, H7);
  private static PokerHand twoPairLow = new PokerHand(C2, D2, C3, H3, D4);
  private static PokerHand twoPairHigh = new PokerHand(CA, HA, CK, HK, CQ);

  @Test
  public void testTwoPairs0() {
    assertTrue(twoPair2.compareTo(twoPair) > 0);
  }

  @Test
  public void testTwoPairs1() {
    assertTrue(twoPairA.compareTo(twoPair2) > 0);
  }

  @Test
  public void testTwoPairs2() {
    assertTrue(twoPairA.compareTo(twoPairLow) > 0);
  }

  @Test
  public void testTwoPairs() {
    assertTrue(twoPairHigh.compareTo(twoPairLow) > 0);
  }

  // TEST 3 OF A KIND
  private static PokerHand threeKind = new PokerHand(D2, H5, H2, H4, C2);
  private static PokerHand threeKind2 = new PokerHand(C5, D5, S5, HA, HK);
  private static PokerHand threeKind3 = new PokerHand(H6, S6, C6, H3, S2);
  private static PokerHand threeKindLow = new PokerHand(D2, C2, H2, H3, H4);
  private static PokerHand threeKindHigh = new PokerHand(CA, HA, DA, CK, CQ);

  @Test
  public void testThreeMiddle3AreTheSameForCodeCoverage() {
    PokerHand threeKind = new PokerHand(D2, S5, D5, H5, CA);
    PokerHand threeKind2 = new PokerHand(C2, S4, D4, H4, SA);

    assertTrue(threeKind.compareTo(threeKind2) > 0);
  }

  @Test
  public void testThreeOfAKind1() {
    assertTrue(threeKind2.compareTo(threeKind) > 0);
  }

  @Test
  public void testThreeOfAKind2() {
    assertTrue(threeKind3.compareTo(threeKind2) > 0);
  }

  @Test
  public void testThreeOfAHigh3() {
    assertTrue(threeKindHigh.compareTo(threeKindLow) > 0);
  }

  @Test
  public void testThreeOfAHigh4() {
    assertTrue(threeKind3.compareTo(threeKindHigh) < 0);
  }

  @Test
  public void testThreeOfAHigh5() {
    assertTrue(threeKindHigh.compareTo(threeKind) > 0);
  }

  private static PokerHand straight = new PokerHand(C4, C6, C2, C5, S3);
  private static PokerHand straightInDifferentSuit = new PokerHand(D2, D3, D4, D5, S6);
  private static PokerHand straightHigh = new PokerHand(C10, HJ, CQ, CK, CA);
  private static PokerHand aceLow = new PokerHand(S2, C3, S4, S5, DA);

  @Test
  public void testStaights1() {
    assertTrue(straight.compareTo(straightInDifferentSuit) == 0);
  }

  @Test
  public void testStaights2() {
    assertTrue(straightHigh.compareTo(straight) > 0);
  }

  @Test
  public void testStaights4() {
    assertTrue(aceLow.compareTo(straight) < 0);
  }

  @Test
  public void testStaights6() {
    assertTrue(aceLow.compareTo(straightHigh) < 0);
  }

  // TEST FLUSHES
  private static PokerHand flush = new PokerHand(H7, H5, H3, H2, HJ);
  private static PokerHand flush2 = new PokerHand(S7, S5, S4, S2, SJ);
  private static PokerHand flushLow = new PokerHand(D2, D3, D4, D5, D7);
  private static PokerHand flushHigh = new PokerHand(CA, CK, CQ, CJ, C9);

  @Test
  public void testFlush() {
    assertTrue(flush.compareTo(flushLow) > 0);
  }

  @Test
  public void testFlush2() {
    assertTrue(flushHigh.compareTo(flushLow) > 0);
  }

  @Test
  public void testFlush3() {
    assertTrue(flush2.compareTo(flush) > 0);
  }

  // TEST FULL HOUSE
  // The higher triple wins
  private static PokerHand fullHouse = new PokerHand(CA, DA, C3, D3, H3);
  private static PokerHand fullHouse2 = new PokerHand(C2, D2, C4, D4, H4);
  private static PokerHand fullHouse3 = new PokerHand(HK, DK, SK, CA, HA);
  private static PokerHand fullHouseLow = new PokerHand(C2, D2, H2, C3, H3);
  private static PokerHand fullHouseHigh = new PokerHand(CA, DA, HA, CK, HK);

  @Test
  public void testFullHouse3() {
    assertTrue(fullHouse2.compareTo(fullHouse) > 0);
  }

  @Test
  public void testFullHouse4() {
    assertTrue(fullHouse3.compareTo(fullHouse2) > 0);
  }

  @Test
  public void testFullHouse5() {
    assertTrue(fullHouse3.compareTo(fullHouse2) > 0);
  }

  @Test
  public void testFullHouse6() {
    assertTrue(fullHouseHigh.compareTo(fullHouseLow) > 0);
  }

  // TEST FOUR OF A KIND
  private static PokerHand fourKindLow = new PokerHand(C2, D2, H2, S2, C3);
  private static PokerHand fourKindMid = new PokerHand(C8, D8, H8, S8, H3);
  private static PokerHand fourKindHigh = new PokerHand(CA, DA, HA, SA, CK);

  @Test
  public void testFourOfAKind1() {
    assertTrue(fourKindMid.compareTo(fourKindLow) > 0);
  }

  @Test
  public void testFourOfAKind2() {
    assertTrue(fourKindHigh.compareTo(fourKindLow) > 0);
  }

  @Test
  public void testFourOfAKind3() {
    assertTrue(fourKindHigh.compareTo(fourKindMid) > 0);
  }

  // TEST FLUSH
  private static PokerHand straightFlush = new PokerHand(H3, H4, H5, H6, H7);
  private static PokerHand straightFlushMid = new PokerHand(H8, H9, H10, HJ, HQ);
  private static PokerHand straightFlushHi = new PokerHand(C10, CJ, CQ, CK, CA);

  @Test
  public void testStraightFlush1() {
    assertTrue(straightFlushMid.compareTo(straightFlush) > 0);
  }

  @Test
  public void testStraightFlush2() {
    assertTrue(straightFlushHi.compareTo(straightFlushMid) > 0);
  }

  @Test
  public void testStraightFlush3() {
    assertTrue(straightFlushHi.compareTo(straightFlush) > 0);
  }

  // Put ranks above others
  @Test
  public void testManyRanks1() {
    assertTrue(straightFlush.compareTo(fourKindHigh) > 0);
  }

  @Test
  public void testManyRanks01() {
    assertTrue(straightFlush.compareTo(pair2) > 0);
  }

  @Test
  public void testManyRanks02() {
    assertTrue(straightFlush.compareTo(twoPair2) > 0);
  }

  @Test
  public void testManyRanks03() {
    assertTrue(straightFlush.compareTo(fullHouse3) > 0);
  }

  @Test
  public void testManyRanks04() {
    assertTrue(straightFlush.compareTo(straight) > 0);
  }

  @Test
  public void testManyRanks05() {
    assertTrue(straightFlush.compareTo(straightHigh) > 0);
  }

  @Test
  public void testManyRanks2() {
    assertTrue(fourKindHigh.compareTo(fullHouse2) > 0);
  }

  @Test
  public void testManyRanks3() {
    assertTrue(fourKindMid.compareTo(fullHouse2) > 0);
  }

  @Test
  public void testManyRanks13() {
    assertTrue(fourKindMid.compareTo(threeKind2) > 0);
  }

  @Test
  public void testManyRanks14() {
    assertTrue(fourKindMid.compareTo(threeKindHigh) > 0);
  }

  @Test
  public void testManyRanks4() {
    assertTrue(fullHouse2.compareTo(threeKind2) > 0);
  }

  @Test
  public void testManyRanks5() {
    assertTrue(fullHouse2.compareTo(threeKind3) > 0);
  }

  @Test
  public void testManyRanks6() {
    assertTrue(fullHouse2.compareTo(threeKind3) > 0);
  }

  @Test
  public void testManyRanks7() {
    assertTrue(threeKind3.compareTo(twoPairHigh) > 0);
  }

  @Test
  public void testManyRanks07() {
    assertTrue(threeKind3.compareTo(pairHigh) > 0);
  }

  @Test
  public void testManyRanks08() {
    assertTrue(threeKind3.compareTo(nothingA) > 0);
  }

  @Test
  public void testManyRanks8() {
    assertTrue(twoPairHigh.compareTo(pair) > 0);
  }

  @Test
  public void testManyRanks9() {
    assertTrue(twoPairHigh.compareTo(pair3) > 0);
  }

  @Test
  public void testManyRanks10() {
    assertTrue(twoPairHigh.compareTo(pairLow) > 0);
  }

  @Test
  public void testManyRanks11() {
    assertTrue(twoPairHigh.compareTo(nothing73) > 0);
  }

  @Test
  public void testManyRanks12() {
    assertTrue(pairHigh.compareTo(nothing73) > 0);
  }

  // Test straigth flushes when the Ace is involved
  private static PokerHand aceLowStaightFush = new PokerHand(HA, H2, H3, H4, H5);
  private static PokerHand aceHighStraightFlush = new PokerHand(DA, DK, DQ, DJ, D10);

  private static PokerHand aceLowStaightFushClubs = new PokerHand(CA, C2, C3, C4, C5);
  private static PokerHand aceHighStraightFlushSpades = new PokerHand(SA, SK, SQ, SJ, S10);

  @Test
  public void testStraightFlushesLowAndHigh() {
    assertTrue(aceHighStraightFlush.compareTo(aceLowStaightFush) > 0);
  }

  @Test
  public void testStraightFlushesLowAndHigh2() {
    assertTrue(aceHighStraightFlushSpades.compareTo(aceLowStaightFushClubs) > 0);
  }

  @Test
  public void testStraightFlushesLowAndHigh3() {
    assertTrue(aceLowStaightFush.compareTo(aceHighStraightFlush) < 0);
  }

  @Test
  public void testStraightFlushesLowAndHigh4() {
    assertTrue(aceLowStaightFushClubs.compareTo(aceHighStraightFlushSpades) < 0);
  }

  // Add three random tests to get to 100 @Tests
  @Test
  public void testStraightFlush00() {
    assertTrue(straightFlushMid.compareTo(fullHouse2) > 0);
  }

  @Test
  public void testManyRanks44() {
    assertTrue(fullHouse2.compareTo(threeKindHigh) > 0);
  }

  @Test
  public void testFinalShouldWorkSinceSoFarApart() {
    PokerHand a = new PokerHand(CA, DK, CQ, DJ, H10);
    PokerHand b = new PokerHand(H2, S3, C4, D5, H6);
    assertTrue(a.compareTo(b) > 0);
  }
}