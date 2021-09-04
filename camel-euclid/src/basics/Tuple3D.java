package basics;

import tools.EuclidCoreTools;
import vector.readOnly.Tuple3DReadOnly;

public interface Tuple3D extends Tuple3DReadOnly, Clearable, Transformable
{
	void setX(double x);

	void setY(double y);

	void setZ(double z);

	/**
	 * Sets all the components of this tuple to zero.
	 */
	@Override
	default void setToZero()
	{
		set(0.0, 0.0, 0.0);
	}

	/**
	 * Sets all the components of this tuple to {@link Double#NaN}.
	 */
	@Override
	default void setToNaN()
	{
		set(Double.NaN, Double.NaN, Double.NaN);
	}

	/** {@inheritDoc} */
	@Override
	default boolean containsNaN()
	{
		return Tuple3DReadOnly.super.containsNaN();
	}

	/**
	 * Sets each component of this tuple to its absolute value.
	 */
	default void absolute()
	{
		set(Math.abs(getX()), Math.abs(getY()), Math.abs(getZ()));
	}

	/**
	 * Changes the sign of each component of this tuple.
	 */
	default void negate()
	{
		set(-getX(), -getY(), -getZ());
	}

	/**
	 * Clips each component of this tuple to a maximum value {@code max}.
	 *
	 * @param max the maximum value for each component.
	 */
	default void clipToMax(double max)
	{
		set(Math.min(max, getX()), Math.min(max, getY()), Math.min(max, getZ()));
	}

	/**
	 * Clips each component of this tuple to a minimum value {@code min}.
	 *
	 * @param min the minimum value for each component.
	 */
	default void clipToMin(double min)
	{
		set(Math.max(min, getX()), Math.max(min, getY()), Math.max(min, getZ()));
	}

	/**
	 * Selects a component of this tuple based on {@code index} and sets it to
	 * {@code value}.
	 * <p>
	 * For an {@code index} of 0, the corresponding component is {@code x}, 1 it is
	 * {@code y}, 2 it is
	 * {@code z}.
	 * </p>
	 *
	 * @param index the index of the component to set.
	 * @param value the new value of the selected component.
	 * @throws IndexOutOfBoundsException if {@code index} &notin; [0, 2].
	 */
	default void setElement(int index, double value)
	{
		switch (index)
		{
		case 0:
			setX(value);
			break;
		case 1:
			setY(value);
			break;
		case 2:
			setZ(value);
			break;
		default:
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
	}

	/**
	 * Sets this tuple's components to {@code x}, {@code y}, and {@code z}.
	 *
	 * @param x the new value for the x-component of this tuple.
	 * @param y the new value for the y-component of this tuple.
	 * @param z the new value for the z-component of this tuple.
	 */
	default void set(double x, double y, double z)
	{
		setX(x);
		setY(y);
		setZ(z);
	}

	/**
	 * Sets this tuple to {@code tupleReadOnly}.
	 *
	 * @param tupleReadOnly the other tuple to copy the values from. Not modified.
	 */
	default void set(Tuple3DReadOnly tupleReadOnly)
	{
		set(tupleReadOnly.getX(), tupleReadOnly.getY(), tupleReadOnly.getZ());
	}

	/**
	 * Sets this tuple's components {@code x}, {@code y}, {@code z} in order from
	 * the given array
	 * {@code tupleArray}.
	 *
	 * @param tupleArray the array containing the new values for this tuple's
	 *                   components. Not modified.
	 */
	default void set(double[] tupleArray)
	{
		set(tupleArray[0], tupleArray[1], tupleArray[2]);
	}

	/**
	 * Sets this tuple's components {@code x}, {@code y}, {@code z} in order from
	 * the given array
	 * {@code tupleArray}.
	 *
	 * @param startIndex the first index to start reading from in the array.
	 * @param tupleArray the array containing the new values for this tuple's
	 *                   components. Not modified.
	 */
	default void set(int startIndex, double[] tupleArray)
	{
		set(tupleArray[startIndex++], tupleArray[startIndex++], tupleArray[startIndex]);
	}

	/**
	 * Sets this tuple's components {@code x}, {@code y}, {@code z} in order from
	 * the given array
	 * {@code tupleArray}.
	 *
	 * @param tupleArray the array containing the new values for this tuple's
	 *                   components. Not modified.
	 */
	default void set(float[] tupleArray)
	{
		set(tupleArray[0], tupleArray[1], tupleArray[2]);
	}

	/**
	 * Sets this tuple's components {@code x}, {@code y}, {@code z} in order from
	 * the given array
	 * {@code tupleArray}.
	 *
	 * @param startIndex the first index to start reading from in the array.
	 * @param tupleArray the array containing the new values for this tuple's
	 *                   components. Not modified.
	 */
	default void set(int startIndex, float[] tupleArray)
	{
		set(tupleArray[startIndex++], tupleArray[startIndex++], tupleArray[startIndex]);
	}

	/**
	 * Sets this tuple to {@code other} and then calls {@link #absolute()}.
	 *
	 * @param other the other tuple to copy the values from. Not modified.
	 */
	default void setAndAbsolute(Tuple3DReadOnly other)
	{
		set(Math.abs(other.getX()), Math.abs(other.getY()), Math.abs(other.getZ()));
	}

	/**
	 * Sets this tuple to {@code other} and then calls {@link #scale(double)}.
	 *
	 * @param scalar the scale factor to use on this tuple.
	 * @param other  the other tuple to copy the values from. Not modified.
	 */
	default void setAndScale(double scalar, Tuple3DReadOnly other)
	{
		set(scalar * other.getX(), scalar * other.getY(), scalar * other.getZ());
	}

	/**
	 * Adds the given {@code x} to this tuple's x-component.
	 *
	 * @param x the value to add.
	 */
	default void addX(double x)
	{
		setX(getX() + x);
	}

	/**
	 * Adds the given {@code y} to this tuple's y-component.
	 *
	 * @param y the value to add.
	 */
	default void addY(double y)
	{
		setY(getY() + y);
	}

	/**
	 * Adds the given {@code z} to this tuple's z-component.
	 *
	 * @param z the value to add.
	 */
	default void addZ(double z)
	{
		setZ(getZ() + z);
	}

	/**
	 * Adds the given ({@code x}, {@code y}, {@code z})-tuple to this tuple.
	 * <p>
	 * this = this + (x, y, z)
	 * </p>
	 *
	 * @param x the value to add to the x-component of this tuple.
	 * @param y the value to add to the y-component of this tuple.
	 * @param z the value to add to the z-component of this tuple.
	 */
	default void add(double x, double y, double z)
	{
		set(getX() + x, getY() + y, getZ() + z);
	}

	/**
	 * Adds the given tuple to this tuple.
	 * <p>
	 * this = this + other
	 * </p>
	 *
	 * @param other the other tuple to add to this tuple. Not modified.
	 */
	default void add(Tuple3DReadOnly other)
	{
		add(other.getX(), other.getY(), other.getZ());
	}

	/**
	 * Sets this tuple to the sum of the two given tuples.
	 * <p>
	 * this = tuple1 + tuple2
	 * </p>
	 *
	 * @param tuple1 the first tuple to sum. Not modified.
	 * @param tuple2 the second tuple to sum. Not modified.
	 */
	default void add(Tuple3DReadOnly tuple1, Tuple3DReadOnly tuple2)
	{
		set(tuple1.getX() + tuple2.getX(), tuple1.getY() + tuple2.getY(), tuple1.getZ() + tuple2.getZ());
	}

	/**
	 * Subtracts the given {@code x} to this tuple's x-component.
	 *
	 * @param x the value to add.
	 */
	default void subX(double x)
	{
		setX(getX() - x);
	}

	/**
	 * Subtracts the given {@code y} to this tuple's y-component.
	 *
	 * @param y the value to add.
	 */
	default void subY(double y)
	{
		setY(getY() - y);
	}

	/**
	 * Subtracts the given {@code z} to this tuple's z-component.
	 *
	 * @param z the value to add.
	 */
	default void subZ(double z)
	{
		setZ(getZ() - z);
	}

	/**
	 * Subtracts the given ({@code x}, {@code y}, {@code z})-tuple to this tuple.
	 * <p>
	 * this = this - (x, y, z)
	 * </p>
	 *
	 * @param x the value to add to the x-component of this tuple.
	 * @param y the value to add to the y-component of this tuple.
	 * @param z the value to add to the z-component of this tuple.
	 */
	default void sub(double x, double y, double z)
	{
		set(getX() - x, getY() - y, getZ() - z);
	}

	/**
	 * Subtracts the given tuple to this tuple.
	 * <p>
	 * this = this - other
	 * </p>
	 *
	 * @param other the other tuple to subtract to this tuple.
	 */
	default void sub(Tuple3DReadOnly other)
	{
		sub(other.getX(), other.getY(), other.getZ());
	}

	/**
	 * Sets this tuple to the difference of the two given tuples.
	 * <p>
	 * this = tuple1 - tuple2
	 * </p>
	 *
	 * @param tuple1 the first tuple. Not modified.
	 * @param tuple2 the second tuple to subtract to {@code tuple1}. Not modified.
	 */
	default void sub(Tuple3DReadOnly tuple1, Tuple3DReadOnly tuple2)
	{
		set(tuple1.getX() - tuple2.getX(), tuple1.getY() - tuple2.getY(), tuple1.getZ() - tuple2.getZ());
	}

	/**
	 * Scales the components of this tuple by the given {@code scalar}.
	 * <p>
	 * this = scalar * this
	 * </p>
	 *
	 * @param scalar the scale factor to use.
	 */
	default void scale(double scalar)
	{
		scale(scalar, scalar, scalar);
	}

	/**
	 * Scales independently each component of this tuple.
	 *
	 * <pre>
	 * / this.x \   / scalarX * this.x \
	 * | this.y | = | scalarY * this.y |
	 * \ this.z /   \ scalarZ * this.z /
	 * </pre>
	 *
	 * @param scalarX the scalar factor to use on the x-component of this tuple.
	 * @param scalarY the scalar factor to use on the y-component of this tuple.
	 * @param scalarZ the scalar factor to use on the z-component of this tuple.
	 */
	default void scale(double scalarX, double scalarY, double scalarZ)
	{
		set(scalarX * getX(), scalarY * getY(), scalarZ * getZ());
	}

	/**
	 * Sets this tuple to the difference of {@code tuple1} scaled and
	 * {@code tuple2}.
	 * <p>
	 * this = scalar * tuple1 - tuple2
	 * </p>
	 *
	 * @param scalar the scale factor to use on {@code tuple1}.
	 * @param tuple1 the first tuple of the difference. Not modified.
	 * @param tuple2 the second tuple of the differenA value of 0 will
	 *               result in not modifying
	 *               this tuple, while a value of 1 is equivalent to setting this
	 *               tuple to {@code other}.
	 */
	default void interpolate(Tuple3DReadOnly other, double alpha)
	{
		interpolate(this, other, alpha);
	}

	/**
	 * Performs a linear interpolation from {@code tuple1} to {@code tuple2} given
	 * the percentage
	 * {@code alpha}.
	 * <p>
	 * this = (1.0 - alpha) * tuple1 + alpha * tuple2
	 * </p>
	 *
	 * @param tuple1 the first tuple used in the interpolation. Not modified.
	 * @param tuple2 the second tuple used in the interpolation. Not modified.
	 * @param alpha  the percentage to use for the interpolation. A value of 0 will
	 *               result in setting
	 *               this tuple to {@code tuple1}, while a value of 1 is equivalent
	 *               to setting this
	 *               tuple to {@code tuple2}.
	 */
	default void interpolate(Tuple3DReadOnly tuple1, Tuple3DReadOnly tuple2, double alpha)
	{
		double x = EuclidCoreTools.interpolate(tuple1.getX(), tuple2.getX(), alpha);
		double y = EuclidCoreTools.interpolate(tuple1.getY(), tuple2.getY(), alpha);
		double z = EuclidCoreTools.interpolate(tuple1.getZ(), tuple2.getZ(), alpha);
		set(x, y, z);
	}
}