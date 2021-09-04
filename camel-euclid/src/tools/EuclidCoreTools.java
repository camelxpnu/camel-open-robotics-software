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

	public static double tan(double a)
	{
		return StrictMath.tan(a);
	}

	public static double atan(double a)
	{
		return StrictMath.atan(a);
	}

	public static double atan2(double y, double x)
	{
		return StrictMath.atan2(y, x);
	}

	public static double cos(double a)
	{
		return StrictMath.cos(a);
	}

	public static double sin(double a)
	{
		return StrictMath.sin(a);
	}

	public static double acos(double a)
	{
		return StrictMath.acos(a);
	}

	public static double asin(double a)
	{
		return StrictMath.asin(a);
	}

	public static boolean containsNaN(double a, double b, double c)
	{
		return Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c);
	}

	public static boolean containsNaN(double a0, double a1, double a2, double a3, double a4, double a5, double a6,
			double a7, double a8)
	{
		if (Double.isNaN(a0) || Double.isNaN(a1) || Double.isNaN(a2))
			return true;
		if (Double.isNaN(a3) || Double.isNaN(a4) || Double.isNaN(a5))
			return true;
		if (Double.isNaN(a6) || Double.isNaN(a7) || Double.isNaN(a8))
			return true;
		return false;
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

	public static double norm(double x, double y, double z)
	{
		return squareRoot(normSquared(x, y, z));
	}

	public static double squareRoot(double value)
	{
		return Math.sqrt(value);
	}

	public static double fastNorm(double x, double y, double z)
	{
		return fastSquareRoot(normSquared(x, y, z));
	}

	public static double fastSquareRoot(double squaredValueClosedToOne)
	{
		if (Math.abs(1.0 - squaredValueClosedToOne) < EPS_NORM_FAST_SQRT)
			squaredValueClosedToOne = 0.5 * (1.0 + squaredValueClosedToOne);
		else
			squaredValueClosedToOne = EuclidCoreTools.squareRoot(squaredValueClosedToOne);

		return squaredValueClosedToOne;
	}

}
