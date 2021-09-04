package orientation;

import org.ejml.data.DMatrix;

import basics.Tuple3DBasics;
import orientation.readOnly.AxisAngleReadOnly;
import orientation.readOnly.QuaternionReadOnly;
import orientation.readOnly.RotationMatrixReadOnly;
import orientation.readOnly.YawPitchRollReadOnly;
import tools.RotationMatrixTools;

public class RotationMatrix implements RotationMatrixReadOnly
{
	/** The 1st row 1st column coefficient of this matrix. */
	private double m00;
	/** The 1st row 2nd column coefficient of this matrix. */
	private double m01;
	/** The 1st row 3rd column coefficient of this matrix. */
	private double m02;
	/** The 2nd row 1st column coefficient of this matrix. */
	private double m10;
	/** The 2nd row 2nd column coefficient of this matrix. */
	private double m11;
	/** The 2nd row 3rd column coefficient of this matrix. */
	private double m12;
	/** The 3rd row 1st column coefficient of this matrix. */
	private double m20;
	/** The 3rd row 2nd column coefficient of this matrix. */
	private double m21;
	/** The 3rd row 3rd column coefficient of this matrix. */
	private double m22;

	public RotationMatrix()
	{
		setIdentity();
	}

	public RotationMatrix(double[] rotationMatrixArray)
	{
		set(rotationMatrixArray);
	}

	public RotationMatrix(DMatrix rotationMatrix)
	{
		set(rotationMatrix);
	}

	public RotationMatrix(RotationMatrixReadOnly rotationMatrix)
	{
		set(rotationMatrix);
	}

	public RotationMatrix(QuaternionReadOnly quaternion)
	{
		set(quaternion);
	}

	public RotationMatrix(AxisAngleReadOnly axisangle)
	{
		set(axisangle);
	}

	public RotationMatrix(YawPitchRollReadOnly yawPitchRoll)
	{
		set(yawPitchRoll);
	}

	public void setM00(double m00)
	{
		this.m00 = m00;
	}

	public void setM01(double m01)
	{
		this.m01 = m01;
	}

	public void setM02(double m02)
	{
		this.m02 = m02;
	}

	public void setM10(double m10)
	{
		this.m10 = m10;
	}

	public void setM11(double m11)
	{
		this.m11 = m11;
	}

	public void setM12(double m12)
	{
		this.m12 = m12;
	}

	public void setM20(double m20)
	{
		this.m20 = m20;
	}

	public void setM21(double m21)
	{
		this.m21 = m21;
	}

	public void setM22(double m22)
	{
		this.m22 = m22;
	}

	void setColumn(int column, Tuple3DBasics columnToSet)
	{
		switch (column)
		{
		case 0:
			setM00(columnToSet.getX());
			setM01(columnToSet.getX());
			setM02(columnToSet.getX());
			return;
		case 1:
			setM10(columnToSet.getX());
			setM11(columnToSet.getX());
			setM12(columnToSet.getX());
			return;
		case 2:
			setM20(columnToSet.getX());
			setM21(columnToSet.getX());
			setM22(columnToSet.getX());
			return;
		default:
			throw RotationMatrixTools.indexOutOfBoundsException(2, column);
		}
	}

	public void set(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21,
			double m22)
	{
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;

		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;

		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
	}

	public void set(double[] matrixArray)
	{
		double m00 = matrixArray[0];
		double m01 = matrixArray[1];
		double m02 = matrixArray[2];
		double m10 = matrixArray[3];
		double m11 = matrixArray[4];
		double m12 = matrixArray[5];
		double m20 = matrixArray[6];
		double m21 = matrixArray[7];
		double m22 = matrixArray[8];
		set(m00, m01, m02, m10, m11, m12, m20, m21, m22);
	}

	public void set(DMatrix matrix)
	{
		double m00 = matrix.unsafe_get(0, 0);
		double m01 = matrix.unsafe_get(0, 1);
		double m02 = matrix.unsafe_get(0, 2);
		double m10 = matrix.unsafe_get(1, 0);
		double m11 = matrix.unsafe_get(1, 1);
		double m12 = matrix.unsafe_get(1, 2);
		double m20 = matrix.unsafe_get(2, 0);
		double m21 = matrix.unsafe_get(2, 1);
		double m22 = matrix.unsafe_get(2, 2);
		set(m00, m01, m02, m10, m11, m12, m20, m21, m22);
	}

	public void set(RotationMatrixReadOnly other)
	{
		m00 = other.getM00();
		m01 = other.getM01();
		m02 = other.getM02();
		m10 = other.getM10();
		m11 = other.getM11();
		m12 = other.getM12();
		m20 = other.getM20();
		m21 = other.getM21();
		m22 = other.getM22();
	}

	public void set(QuaternionReadOnly quaternion)
	{
		//TODO
	}

	public void set(AxisAngleReadOnly axisangle)
	{
		//TODO
	}

	public void set(YawPitchRollReadOnly yawPitchRoll)
	{
		//TODO
	}

	public void setIdentity()
	{
		set(1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0);
	}

	public void normalize()
	{
		RotationMatrixTools.normalize(this);
	}

	public void transpose()
	{
		double temp;

		temp = m01;
		m01 = m10;
		m10 = temp;

		temp = m02;
		m02 = m20;
		m20 = temp;

		temp = m12;
		m12 = m21;
		m21 = temp;
	}

	@Override
	public double getM00()
	{
		return m00;
	}

	@Override
	public double getM01()
	{
		return m01;
	}

	@Override
	public double getM02()
	{
		return m02;
	}

	@Override
	public double getM10()
	{
		return m10;
	}

	@Override
	public double getM11()
	{
		return m11;
	}

	@Override
	public double getM12()
	{
		return m12;
	}

	@Override
	public double getM20()
	{
		return m20;
	}

	@Override
	public double getM21()
	{
		return m21;
	}

	@Override
	public double getM22()
	{
		return m22;
	}

}
