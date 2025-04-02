CREATE TRIGGER fill_history_of_price_trigger
	AFTER INSERT
	ON products
	FOR EACH ROW
	EXECUTE PROCEDURE fill_history_of_price();

CREATE OR REPLACE FUNCTION fill_history_of_price()
	RETURNS TRIGGER AS
$$
	BEGIN
		INSERT INTO history_of_price (name, price, date)
		VALUES (new.name, new.price, CURRENT_DATE)
		RETURN NEW;
	END;
$$
LANGUAGE 'plpgsql';
	