package basics;

import tools.EuclidCoreTools;

public abstract class Tuple3DBasics implements Tuple3D
{
	/** The x-coordinate. */
	private double x;
	/** The y-coordinate. */
	private double y;
	/** The z-coordinate. */
	private double z;

	@Override
	public double getX()
	{
		return x;
	}

	@Override
	public double getY()
	{
		return y;
	}

	@Override
	public double getZ()
	{
		return z;
	}

	@Override
	public void applyTransform(Transform transform)
	{
		transform.transform(this);
	}

	@Override
	public void applyInverseTransform(Transform transform)
	{
		transform.inverseTransform(this);
	}

	@Override
	public void setX(double x)
	{
		this.x = x;
	}

	@Override
	public void setY(double y)
	{
		this.y = y;
	}

	@Override
	public void setZ(double z)
	{
		this.z = z;
	}

	public double length()
	{
		return EuclidCoreTools.squareRoot(lengthSquared());
	}

	public double lengthSquared()
	{
		return EuclidCoreTools.normSquared(getX(), getY(), getZ());
	}

	@Override
	public String toString()
	{
		return (getX() + ", " + getY() + ", " + getZ());
	}
}