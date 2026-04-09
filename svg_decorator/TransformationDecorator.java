import java.util.Locale;

public class TransformationDecorator extends ShapeDecorator{
    private String transform;

    public TransformationDecorator(Shape decoratedShape, Vec2 translation) {
        super(decoratedShape);
        Builder builder = new Builder().translate(translation);
        transform = builder.build();
    }

    @Override
    public String toSvg() {
        return this.decoratedShape.toSvg().replace("/>",
                String.format(" transform=\"%s\"/>", transform));
    }

    public static class Builder{

        private Vec2 translation;
        private double rotation;
        private Vec2 scale;

        public Builder translate(Vec2 translation){
            this.translation = translation;
            return this;
        }

        public String build(){
            String result = "";
            if (translation != null) {
                result = String.format(Locale.ENGLISH,
                        " translate(%f %f)",
                        translation.x(), translation.y());
            }
            return result;
        }

    }
}

