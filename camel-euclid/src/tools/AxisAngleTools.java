package tools;

import orientation.Quaternion;
import orientation.RotationMatrix;
import orientation.readOnly.AxisAngleReadOnly;

public class AxisAngleTools
{
	public static double distance(AxisAngleReadOnly aa1, AxisAngleReadOnly aa2)
	{
		double alpha = aa1.getAngle();
		double u1x = aa1.getX();
		double u1y = aa1.getY();
		double u1z = aa1.getZ();

		double beta = -aa2.getAngle();
		double u2x = aa2.getX();
		double u2y = aa2.getY();
		double u2z = aa2.getZ();

		double cosHalfAlpha = EuclidCoreTools.cos(0.5 * alpha);
		double sinHalfAlpha = EuclidCoreTools.sin(0.5 * alpha);
		double cosHalfBeta = EuclidCoreTools.cos(0.5 * beta);
		double sinHalfBeta = EuclidCoreTools.sin(0.5 * beta);

		double dot = u1x * u2x + u1y * u2y + u1z * u2z;
		double crossX = u1y * u2z - u1z * u2y;
		double crossY = u1z * u2x - u1x * u2z;
		double crossZ = u1x * u2y - u1y * u2x;

		double sinCos = sinHalfAlpha * cosHalfBeta;
		double cosSin = cosHalfAlpha * sinHalfBeta;
		double cosCos = cosHalfAlpha * cosHalfBeta;
		double sinSin = sinHalfAlpha * sinHalfBeta;

		double cosHalfGamma = cosCos - sinSin * dot;

		double sinHalfGammaUx = sinCos * u1x + cosSin * u2x + sinSin * crossX;
		double sinHalfGammaUy = sinCos * u1y + cosSin * u2y + sinSin * crossY;
		double sinHalfGammaUz = sinCos * u1z + cosSin * u2z + sinSin * crossZ;

		double sinHalfGamma = EuclidCoreTools.norm(sinHalfGammaUx, sinHalfGammaUy, sinHalfGammaUz);

		double gamma = 2.0 * EuclidCoreTools.atan2(sinHalfGamma, cosHalfGamma);
		return Math.abs(gamma);
	}

	//TODO: Implement conversions.
	public static Quaternion convertAxisAngleToQuaternion(Quaternion quaternion)
	{
		return null;
	}
	
	//TODO: Implement conversions.
	public static RotationMatrix convertAxisAngleToRotationMatrix(RotationMatrix rotationMatrix)
	{
		return null;
	}
}
