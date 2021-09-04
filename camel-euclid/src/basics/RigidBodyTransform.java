package basics;

import orientation.RotationMatrix;
import orientation.readOnly.RotationMatrixReadOnly;
import vector.Vector3D;
import vector.readOnly.Tuple3DReadOnly;

public class RigidBodyTransform implements RigidBodyTransformReadOnly
{
	private final RotationMatrix rotationMatrix = new RotationMatrix();
	private final Vector3D translationVector = new Vector3D();

	public RigidBodyTransform()
	{
		this.rotationMatrix.setIdentity();
		this.translationVector.setToZero();
	}

	public RigidBodyTransform(RigidBodyTransform other)
	{
		this.rotationMatrix.set(other.getRotation());
		this.translationVector.set(other.getTranslation());
	}

	public RigidBodyTransform(RotationMatrixReadOnly rotationMatrix, Tuple3DReadOnly translation)
	{
		this.rotationMatrix.set(rotationMatrix);
		this.translationVector.set(translation);
	}

	public RigidBodyTransform(RotationMatrixReadOnly rotationMatrix)
	{
		this.rotationMatrix.set(rotationMatrix);
		this.translationVector.setToZero();
	}

	public RigidBodyTransform(Tuple3DReadOnly translation)
	{
		this.rotationMatrix.setIdentity();
		this.translationVector.set(translation);
	}

	public void setRotation(RotationMatrixReadOnly rotation)
	{
		this.rotationMatrix.set(rotation);
	}

	public void setTranslation(Tuple3DReadOnly translation)
	{
		this.translationVector.set(translation);
	}

	public void invert()
	{
		this.rotationMatrix.transpose();
		getRotation().transform(this.translationVector);
		this.translationVector.negate();
	}

	@Override
	public RotationMatrixReadOnly getRotation()
	{
		return rotationMatrix;
	}

	@Override
	public Tuple3DReadOnly getTranslation()
	{
		return translationVector;
	}
}
