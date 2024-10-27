package nl.koetsier.irisserver;

public record Iris(
    float sepalLengthCm,
    float sepalWidthCm,
    float petalLengthCm,
    float petalWidthCm,
    String irisClass) {

}
