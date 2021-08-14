package tools;

import org.ejml.MatrixDimensionException;
import org.ejml.data.DMatrix;

import basics.Tuple3DBasics;
import orientation.RotationMatrix;
import orientation.readOnly.RotationMatrixReadOnly;
import vector.readOnly.Tuple3DReadOnly;

public class RotationMatrixTools
{
	public static double determinant(double m00, double m01, double m02, double m10, double m11, double m12, double m20,
			double m21, double m22)
	{
		double det;
		det = m00 * (m11 * m22 - m12 * m21);
		det += m01 * (m12 * m20 - m10 * m22);
		det += m02 * (m10 * m21 - m11 * m20);
		return det;
	}

	public static void normalize(RotationMatrix matrixToNormalize)
	{
		double m00 = matrixToNormalize.getM00();
		double m01 = matrixToNormalize.getM01();
		double m02 = matrixToNormalize.getM02();
		double m10 = matrixToNormalize.getM10();
		double m11 = matrixToNormalize.getM11();
		double m12 = matrixToNormalize.getM12();
		double m20 = matrixToNormalize.getM20();
		double m21 = matrixToNormalize.getM21();
		double m22 = matrixToNormalize.getM22();

		double xdoty = m00 * m01 + m10 * m11 + m20 * m21;
		double xdotx = m00 * m00 + m10 * m10 + m20 * m20;
		double tmp = xdoty / xdotx;

		m01 -= tmp * m00;
		m11 -= tmp * m10;
		m21 -= tmp * m20;

		double zdoty = m02 * m01 + m12 * m11 + m22 * m21;
		double zdotx = m02 * m00 + m12 * m10 + m22 * m20;
		double ydoty = m01 * m01 + m11 * m11 + m21 * m21;

		tmp = zdotx / xdotx;
		double tmp1 = zdoty / ydoty;

		m02 -= tmp * m00 + tmp1 * m01;
		m12 -= tmp * m10 + tmp1 * m11;
		m22 -= tmp * m20 + tmp1 * m21;

		// Compute orthogonalized vector magnitudes and normalize
		double invMagX = 1.0 / EuclidCoreTools.fastNorm(m00, m10, m20);
		double invMagY = 1.0 / EuclidCoreTools.fastNorm(m01, m11, m21);
		double invMagZ = 1.0 / EuclidCoreTools.fastNorm(m02, m12, m22);

		m00 *= invMagX;
		m01 *= invMagY;
		m02 *= invMagZ;
		m10 *= invMagX;
		m11 *= invMagY;
		m12 *= invMagZ;
		m20 *= invMagX;
		m21 *= invMagY;
		m22 *= invMagZ;
		matrixToNormalize.set(m00, m01, m02, m10, m11, m12, m20, m21, m22);
	}

	public static void transform(RotationMatrixReadOnly matrix, Tuple3DReadOnly tupleOriginal, Tuple3DBasics tupleTransformed)
	{
		double x = matrix.getM00() * tupleOriginal.getX() + matrix.getM01() * tupleOriginal.getY()
				+ matrix.getM02() * tupleOriginal.getZ();
		double y = matrix.getM10() * tupleOriginal.getX() + matrix.getM11() * tupleOriginal.getY()
				+ matrix.getM12() * tupleOriginal.getZ();
		double z = matrix.getM20() * tupleOriginal.getX() + matrix.getM21() * tupleOriginal.getY()
				+ matrix.getM22() * tupleOriginal.getZ();
		tupleTransformed.set(x, y, z);
	}

	public static void check3x3(DMatrix matrixToTest)
	{
		if (matrixToTest.getNumCols() != 3 || matrixToTest.getNumRows() != 3)
		{
			throw new MatrixDimensionException("The size of the matrix is not 3x3.");
		}
	}

	public static ArrayIndexOutOfBoundsException indexOutOfBoundsException(int maxIndex, int index)
	{
		return new ArrayIndexOutOfBoundsException("index should be in [0, " + maxIndex + "], but is: " + index);
	}
}
