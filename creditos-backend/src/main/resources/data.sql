CREATE TABLE IF NOT EXISTS credito(
	id            	BIGINT GENERATED BY DEFAULT AS IDENTITY,
	numero_credito	VARCHAR(50)	NOT NULL,
	numero_nfse   	VARCHAR(50)	NOT NULL,
	data_constituicao DATE       	NOT NULL,
	valor_issqn   	DECIMAL(15, 2) NOT NULL,
	tipo_credito  	VARCHAR(50)	NOT NULL,
	simples_nacional  BOOLEAN    	NOT NULL,
	aliquota      	DECIMAL(5, 2)  NOT NULL,
	valor_faturado	DECIMAL(15, 2) NOT NULL,
	valor_deducao 	DECIMAL(15, 2) NOT NULL,
	base_calculo  	DECIMAL(15, 2) NOT NULL
);

DELETE FROM credito;

INSERT INTO credito (numero_credito, numero_nfse, data_constituicao, valor_issqn, tipo_credito, simples_nacional, aliquota, valor_faturado, valor_deducao, base_calculo)
VALUES
('123456', '7891011', '2024-02-25', 1500.75, 'ISSQN', true, 5.0, 30000.00, 5000.00, 25000.00),
('789012', '7891011', '2024-02-26', 1200.50, 'ISSQN', false, 4.5, 25000.00, 4000.00, 21000.00),
('654321', '1122334', '2024-01-15', 800.50, 'Outros', true, 3.5, 20000.00, 3000.00, 17000.00);

