package cubetimer;

import java.util.Random;

import fields.Fields;
import fields.TwistyPuzzleType;

public class Scrambler {

	private Fields fields;
	private Paint paint;

	private String randomScramble;
	private String randomMove;

	private int lastFaceMovedInInt;
	private int faceMovedInInt;
	private int moveDirectionInInt;
	private int faceDepthInInt;
	private int faceMoved2TimesAgoInInt;

	private Random random;

	public Scrambler(Fields f, Paint p) {

		fields = f;
		paint = p;

		random = new Random();

		randomCorrectScrambleInFieldsUsingFields();

		paint.repaint();
	}

	private static String intTo3x3Turn(int face, int symbol) {

		String faces = "ULFRBD";
		String symbols = " '2";

		return "" + faces.charAt(face) + symbols.charAt(symbol);

	}

	private static String intTo2x2Turn(int face, int symbol) {

		String faces = "RUF";
		String symbols = " '2";

		return "" + faces.charAt(face) + symbols.charAt(symbol);
	}

	private static String
			intTo4x4Or5x5Turn(int face, int faceDepth, int symbol) {

		String outerFaces = "ULFRBD";
		String symbols = " '2";

		if (faceDepth == 1) {
			return outerFaces.charAt(face) + "w" + symbols.charAt(symbol);
		} else {
			return outerFaces.charAt(face) + "" + symbols.charAt(symbol);
		}
	}

	private static String intToGearCubeTurn(int face, int symbol) {

		String faces = "RUF";
		String symbols = " '";

		return faces.charAt(face) + "2" + symbols.charAt(symbol);
	}

	private static String intToAnisatopricGearCubeTurn(int face, int symbol) {

		String faces = "RF";
		String symbols = " '";

		if (face == 2) {
			return "U" + symbols.charAt(symbol);
		} else {
			return "" + faces.charAt(face) + "2" + symbols.charAt(symbol);
		}
	}

	private String random3x3Scramble(int scrambleLength) {

		for (int i = 0; i < scrambleLength; i++) {

			faceMovedInInt = random.nextInt(6);

			if (lastFaceMovedInInt == faceMovedInInt
					|| faceMoved2TimesAgoInInt == faceMovedInInt) {
				i--;
			} else {
				faceMoved2TimesAgoInInt = lastFaceMovedInInt;
				lastFaceMovedInInt = faceMovedInInt;
				moveDirectionInInt = random.nextInt(3);
				randomMove = intTo3x3Turn(faceMovedInInt, moveDirectionInInt);

				if (i == 0) {
					randomScramble = randomMove;
				} else {
					randomScramble = randomScramble + " " + randomMove;
				}

			}
		}
		return randomScramble;
	}

	private String random2x2Scramble(int scrambleLength) {

		for (int i = 0; i < scrambleLength; i++) {

			faceMovedInInt = random.nextInt(3);

			if (lastFaceMovedInInt == faceMovedInInt) {
				i--;
			} else {
				lastFaceMovedInInt = faceMovedInInt;
				moveDirectionInInt = random.nextInt(3);
				randomMove = intTo2x2Turn(faceMovedInInt, moveDirectionInInt);

				if (i == 0) {
					randomScramble = randomMove;
				} else {
					randomScramble = randomScramble + " " + randomMove;
				}
			}
		}
		return randomScramble;
	}

	private String random4x4Or5x5Scramble(int scrambleLenght) {

		for (int i = 0; i < scrambleLenght; i++) {

			faceMovedInInt = random.nextInt(6);

			if (lastFaceMovedInInt == faceMovedInInt) {
				i--;
			} else {
				faceMoved2TimesAgoInInt = lastFaceMovedInInt;
				lastFaceMovedInInt = faceMovedInInt;
				faceDepthInInt = random.nextInt(2);
				moveDirectionInInt = random.nextInt(3);
				randomMove =
						intTo4x4Or5x5Turn(faceMovedInInt, faceDepthInInt,
								moveDirectionInInt);

				if (i == 0) {
					randomScramble = randomMove;
				} else {
					randomScramble = randomScramble + " " + randomMove;
				}
			}
		}
		return randomScramble;
	}

	private String curvyCopterScramble() {

		return "No Curvy Copter Scramble Avaliable";
	}

	private String randomMegaMinxScramble(int scrambleLength) {

		int j = 1;
		boolean rNext;
		int randomNumber;
		rNext = random.nextBoolean();
		String symbols = "+-";
		String otherSymbols = "' ";

		for (int i = 0; i < scrambleLength; i++) {

			if (j >= 10) {
				j = 1;
				randomMove =
						"U" + otherSymbols.charAt(random.nextInt(2)) + "/n";
			} else {
				j++;
				if (rNext) {
					randomNumber = random.nextInt(2);
					randomMove =
							"R" + symbols.charAt(randomNumber)
									+ symbols.charAt(randomNumber);
					rNext = false;
				} else {
					rNext = true;
					randomNumber = random.nextInt(2);
					randomMove =
							"D" + symbols.charAt(randomNumber)
									+ symbols.charAt(randomNumber);
				}
			}
			if (i < 1) {
				randomScramble = randomMove;
			} else {
				randomScramble = randomScramble + " " + randomMove;
			}
		}
		return randomScramble;
	}

	private String randomGearCubeScramble(int scrambleSize) {

		int faceTurn;
		int lastFaceTurn = 4;

		for (int i = 0; i < scrambleSize; i++) {

			faceTurn = random.nextInt(3);

			if (faceTurn == lastFaceTurn) {
				i--;
			} else {
				lastFaceTurn = faceTurn;
				randomMove = intToGearCubeTurn(faceTurn, random.nextInt(2));

				if (i == 0) {
					randomScramble = randomMove;
				} else {
					randomScramble = randomScramble + " " + randomMove;
				}
			}
		}
		return randomScramble;
	}

	private String randomAnisatropicGearCubeScramble(int scrambleSize) {

		int faceTurn;
		int lastFaceTurn = 4;

		for (int i = 0; i < scrambleSize; i++) {

			faceTurn = random.nextInt(3);

			if (faceTurn == lastFaceTurn) {
				i--;
			} else {
				lastFaceTurn = faceTurn;
				randomMove =
						intToAnisatopricGearCubeTurn(faceTurn,
								random.nextInt(2));
			}
			if (i == 0) {
				randomScramble = randomMove;
			} else {
				randomScramble = randomScramble + " " + randomMove;
			}
		}
		return randomScramble;
	}

	public String randomCorrectScramble(TwistyPuzzleType twistyPuzzleType,
			int scrambleSize) {

		if (twistyPuzzleType == TwistyPuzzleType.cube2x2x2) {
			return random2x2Scramble(scrambleSize);
		} else if (twistyPuzzleType == TwistyPuzzleType.cube4x4x4) {
			return random4x4Or5x5Scramble(scrambleSize);
		} else if (twistyPuzzleType == TwistyPuzzleType.cube5x5x5) {
			return random4x4Or5x5Scramble(scrambleSize);
		} else if (twistyPuzzleType == TwistyPuzzleType.curvyCopter) {
			return curvyCopterScramble();
		} else if (twistyPuzzleType == TwistyPuzzleType.megaMinx) {
			return randomMegaMinxScramble(scrambleSize);
		} else if (twistyPuzzleType == TwistyPuzzleType.gearCube) {
			return randomGearCubeScramble(scrambleSize);
		} else if (twistyPuzzleType == TwistyPuzzleType.cube3x3x3) {
			return random3x3Scramble(scrambleSize);
		} else if (twistyPuzzleType == TwistyPuzzleType.anisatropicGearCube) {
			return randomAnisatropicGearCubeScramble(scrambleSize);
		} else if (twistyPuzzleType == TwistyPuzzleType.oneHanded3x3x3) {
			return random3x3Scramble(scrambleSize);
		} else {
			return "we can't scramble that twisty puzzle for you yet";
		}
	}

	public void randomCorrectScrambleInFieldsUsingFields() {

		Actions.setScrambleInFields(
				fields,
				randomCorrectScramble(fields.getAllUsers().getUser()
						.getTwistyPuzzleType(),
						fields.getDisplayedData().getScrambleData().getScrambleLenght()));

		paint.repaint();
	}
}
