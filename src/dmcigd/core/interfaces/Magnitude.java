package dmcigd.core.interfaces;

public interface Magnitude {
	enum Unit {
		MILLISECOND, SECOND, MINUTE, HOUR,
		MILLIMETRE, CENTIMETRE, METRE, KILOMETRE,
		MILLIGRAM, GRAM, KILOGRAM,
		MILLILITRE, LITRE,
		PIXEL
	};
	Magnitude add();
	Magnitude subtract();
	Integer getValue();
	Boolean setValue();
	Magnitude convertTo(Unit unit);
}
