package basics;

public interface Transform
{
	void transform(Tuple3DBasics tuple3dToTransform);

	void inverseTransform(Tuple3DBasics tuple3dToInverseTransform);
}
