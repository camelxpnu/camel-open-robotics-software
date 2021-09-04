package orientation.readOnly;

import org.ejml.data.DMatrix;

import basics.Tuple3DBasics;
import tools.EuclidCoreTools;
import tools.RotationMatrixTools;
import vector.readOnly.Tuple3DReadOnly;

public interface RotationMatrixReadOnly
{
	double getM00();

	double getM01();

	double getM02();

	double getM10();

	double getM11();

	double getM12();

	double getM20();

	double getM21();

	double getM22();

	default double getElement(int row, int column)
	{
		switch (row)
		{
		case 0:
			switch (column)
			{
			case 0:
				return getM00();
			case 1:
				return getM01();
			case 2:
				return getM02();
			default:
				throw RotationMatrixTools.indexOutOfBoundsException(2, column);
			}
		case 1:
			switch (column)
			{
			case 0:
				return getM10();
			case 1:
				return getM11();
			case 2:
				return getM12();
			default:
				throw RotationMatrixTools.indexOutOfBoundsException(2, column);
			}

		case 2:
			switch (column)
			{
			case 0:
				return getM20();
			case 1:
				return getM21();
			case 2:
				return getM22();
			default:
				throw RotationMatrixTools.indexOutOfBoundsException(2, column);
			}

		default:
			throw RotationMatrixTools.indexOutOfBoundsException(2, row);
		}
	}

	default void get(double[] matrixArrayToPack)
	{
		matrixArrayToPack[0] = getM00();
		matrixArrayToPack[1] = getM01();
		matrixArrayToPack[2] = getM02();
		matrixArrayToPack[3] = getM10();
		matrixArrayToPack[4] = getM11();
		matrixArrayToPack[5] = getM12();
		matrixArrayToPack[6] = getM20();
		matrixArrayToPack[7] = getM21();
		matrixArrayToPack[8] = getM22();
	}

	default void get(int startIndex, double[] matrixArrayToPack)
	{
		matrixArrayToPack[startIndex++] = getM00();
		matrixArrayToPack[startIndex++] = getM01();
		matrixArrayToPack[startIndex++] = getM02();
		matrixArrayToPack[startIndex++] = getM10();
		matrixArrayToPack[startIndex++] = getM11();
		matrixArrayToPack[startIndex++] = getM12();
		matrixArrayToPack[startIndex++] = getM20();
		matrixArrayToPack[startIndex++] = getM21();
		matrixArrayToPack[startIndex] = getM22();
	}

	default void get(DMatrix matrixToPack)
	{
		RotationMatrixTools.check3x3(matrixToPack);

		matrixToPack.unsafe_set(0, 0, getM00());
		matrixToPack.unsafe_set(0, 1, getM01());
		matrixToPack.unsafe_set(0, 2, getM02());
		matrixToPack.unsafe_set(1, 0, getM10());
		matrixToPack.unsafe_set(1, 1, getM11());
		matrixToPack.unsafe_set(1, 2, getM12());
		matrixToPack.unsafe_set(2, 0, getM20());
		matrixToPack.unsafe_set(2, 1, getM21());
		matrixToPack.unsafe_set(2, 2, getM22());
	}

	default void get(int startRow, int startColumn, DMatrix matrixToPack)
	{
		RotationMatrixTools.check3x3(matrixToPack);

		int row = startRow;
		int column = startColumn;
		matrixToPack.unsafe_set(row, column++, getM00());
		matrixToPack.unsafe_set(row, column++, getM01());
		matrixToPack.unsafe_set(row++, column, getM02());
		column = startColumn;
		matrixToPack.unsafe_set(row, column++, getM10());
		matrixToPack.unsafe_set(row, column++, getM11());
		matrixToPack.unsafe_set(row++, column, getM12());
		column = startColumn;
		matrixToPack.unsafe_set(row, column++, getM20());
		matrixToPack.unsafe_set(row, column++, getM21());
		matrixToPack.unsafe_set(row, column, getM22());
	}

	default void getColumn(int column, double columnArrayToPack[])
	{
		switch (column)
		{
		case 0:
			columnArrayToPack[0] = getM00();
			columnArrayToPack[1] = getM10();
			columnArrayToPack[2] = getM20();
			return;
		case 1:
			columnArrayToPack[0] = getM01();
			columnArrayToPack[1] = getM11();
			columnArrayToPack[2] = getM21();
			return;
		case 2:
			columnArrayToPack[0] = getM02();
			columnArrayToPack[1] = getM12();
			columnArrayToPack[2] = getM22();
			return;
		default:
			throw RotationMatrixTools.indexOutOfBoundsException(2, column);
		}
	}

	default void getColumn(int column, Tuple3DBasics columnToPack)
	{
		switch (column)
		{
		case 0:
			columnToPack.setX(getM00());
			columnToPack.setY(getM10());
			columnToPack.setZ(getM20());
			return;
		case 1:
			columnToPack.setX(getM01());
			columnToPack.setY(getM11());
			columnToPack.setZ(getM21());
			return;
		case 2:
			columnToPack.setX(getM02());
			columnToPack.setY(getM12());
			columnToPack.setZ(getM22());
			return;
		default:
			throw RotationMatrixTools.indexOutOfBoundsException(2, column);
		}
	}

	default void getRow(int row, double rowArrayToPack[])
	{
		switch (row)
		{
		case 0:
			rowArrayToPack[0] = getM00();
			rowArrayToPack[1] = getM01();
			rowArrayToPack[2] = getM02();
			return;
		case 1:
			rowArrayToPack[0] = getM10();
			rowArrayToPack[1] = getM11();
			rowArrayToPack[2] = getM12();
			return;
		case 2:
			rowArrayToPack[0] = getM20();
			rowArrayToPack[1] = getM21();
			rowArrayToPack[2] = getM22();
			return;
		default:
			throw RotationMatrixTools.indexOutOfBoundsException(2, row);
		}
	}

	default void getRow(int row, Tuple3DBasics rowToPack)
	{
		switch (row)
		{
		case 0:
			rowToPack.setX(getM00());
			rowToPack.setY(getM01());
			rowToPack.setZ(getM02());
			return;
		case 1:
			rowToPack.setX(getM10());
			rowToPack.setY(getM11());
			rowToPack.setZ(getM12());
			return;
		case 2:
			rowToPack.setX(getM20());
			rowToPack.setY(getM21());
			rowToPack.setZ(getM22());
			return;
		default:
			throw RotationMatrixTools.indexOutOfBoundsException(2, row);
		}
	}

	default boolean containsNaN()
	{
		return EuclidCoreTools.containsNaN(getM00(), getM01(), getM02(), getM10(), getM11(), getM12(), getM20(),
				getM21(), getM22());
	}

	default double determinant()
	{
		return RotationMatrixTools.determinant(getM00(), getM01(), getM02(), getM10(), getM11(), getM12(), getM20(),
				getM21(), getM22());
	}

	default void transform(Tuple3DBasics tupleOriginal, Tuple3DBasics tupleTransformed)
	{
		RotationMatrixTools.transform(this, tupleOriginal, tupleTransformed);
	}

	default void inverseTransform(Tuple3DBasics tuple3dToInverseTransform)
	{
		double x = getM00() * tuple3dToInverseTransform.getX() + getM10() * tuple3dToInverseTransform.getY()
				+ getM20() * tuple3dToInverseTransform.getZ();
		double y = getM01() * tuple3dToInverseTransform.getX() + getM11() * tuple3dToInverseTransform.getY()
				+ getM21() * tuple3dToInverseTransform.getZ();
		double z = getM02() * tuple3dToInverseTransform.getX() + getM12() * tuple3dToInverseTransform.getY()
				+ getM22() * tuple3dToInverseTransform.getZ();
		tuple3dToInverseTransform.set(x, y, z);
	}

	default void transform(Tuple3DBasics translation)
	{
		transform(translation, translation);
	}
}
