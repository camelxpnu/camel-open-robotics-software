package basics;

import orientation.RotationMatrix;
import orientation.readOnly.RotationMatrixReadOnly;
import vector.readOnly.Tuple3DReadOnly;

public interface RigidBodyTransformReadOnly extends Transform
{
	RotationMatrixReadOnly getRotation();

	Tuple3DReadOnly getTranslation();

	default boolean containsNaN()
	{
		return getRotation().containsNaN() || getTranslation().containsNaN();
	}

	default double getTranslationX()
	{
		return getTranslation().getX();
	}

	default double getTranslationY()
	{
		return getTranslation().getY();
	}

	default double getTranslationZ()
	{
		return getTranslation().getZ();
	}

	default void get(RotationMatrix orientationToPack, Tuple3DBasics translationToPack)
	{
		orientationToPack.set(getRotation());
		translationToPack.set(getTranslation());
	}
	
	default void get(RigidBodyTransform transformToPack)
	{
		transformToPack.setRotation(getRotation());
		transformToPack.setTranslation(getTranslation());
	}
	
	@Override
	default void transform(Tuple3DBasics tuple3dToTransform)
	{
		getRotation().transform(tuple3dToTransform, tuple3dToTransform);
		tuple3dToTransform.add(getTranslation());
	}
	
	@Override
	default void inverseTransform(Tuple3DBasics tuple3dToInverseTransform)
	{
		tuple3dToInverseTransform.sub(getTranslation());
		getRotation().inverseTransform(tuple3dToInverseTransform);
	}
}
