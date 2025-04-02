CREATE TRIGGER tax_trigger_2
	BEFORE INSERT
	ON products
	FOR EACH ROW
	EXECUTE PROCEDURE tax_2();

CREATE OR REPLACE FUNCTION tax_2()
	RETURNS TRIGGER AS
$$
	BEGIN
		UPDATE products
		SET price = price * 1.1
		WHERE id = new.id;
		RETURN NEW;
	END;
$$
LANGUAGE 'plpgsql';