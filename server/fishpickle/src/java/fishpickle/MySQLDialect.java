package fishpickle;

import java.sql.Types;

import org.hibernate.dialect.MySQL5InnoDBDialect;

public class MySQLDialect extends MySQL5InnoDBDialect{
	
	public MySQLDialect() {
		registerColumnType(Types.BIT, "boolean");
	}

}
