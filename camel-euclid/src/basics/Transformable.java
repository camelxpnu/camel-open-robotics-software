package basics;

public interface Transformable
{
	/**
	 * Transform this using the given {@code transform}.
	 *
	 * @param transform the transform to use on this. Not modified.
	 */
	public abstract void applyTransform(Transform transform);

	/**
	 * Transform this using the inverse of the given {@code transform}.
	 *
	 * @param transform the transform to use on this. Not modified.
	 */
	public abstract void applyInverseTransform(Transform transform);
}