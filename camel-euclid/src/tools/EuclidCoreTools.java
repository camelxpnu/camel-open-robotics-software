package tools;

public class EuclidCoreTools
{
	/**
	 * This field is used to save unnecessary computation and represents the number
	 * {@code 2.0 * Math.PI}.
	 */
	public static final double TwoPI = 2.0 * Math.PI;

	/**
	 * Magic number used as a tolerance for switching to the fast square-root
	 * formula.
	 */
	public static final double EPS_NORM_FAST_SQRT = 2.107342e-08;
	/**
	 * An epsilon that is just slightly bigger than numerical inaccuracies used in
	 * {@link #shiftAngleInRange(double, double)}.
	 */
	public static final double EPS_ANGLE_SHIFT = 1.0e-12;
	/**
	 * Tolerance used in {@link #clamp(double, double, double)} to verify the bounds
	 * are sane.
	 */
	public static final double CLAMP_EPS = 1.0e-10;

	public static boolean containsNaN(double a, double b, double c)
	{
		return Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c);
	}

	/**
	 * Performs a linear interpolation from {@code a} to {@code b} given the
	 * percentage {@code alpha}.
	 * <p>
	 * result = (1.0 - alpha) * a + alpha * b
	 * </p>
	 *
	 * @param a     the first value used in the interpolation.
	 * @param b     the second value used in the interpolation.
	 * @param alpha the percentage to use for the interpolation. A value of 0 will
	 *              return {@code a},
	 *              while a value of 1 will return {@code b}.
	 * @return the interpolated value.
	 */
	public static double interpolate(double a, double b, double alpha)
	{
		return (1.0 - alpha) * a + alpha * b;
	}

	public static double normSquared(double x, double y, double z)
	{
		return x * x + y * y + z * z;
	}

	public static double squareRoot(double value)
	{
		return Math.sqrt(value);
	}
}