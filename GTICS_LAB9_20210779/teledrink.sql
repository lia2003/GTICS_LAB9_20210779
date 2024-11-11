CREATE DATABASE teledrink;
USE teledrink;
CREATE TABLE Cocktail (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    instructions TEXT,
    imageUrl VARCHAR(255)
);
CREATE USER 'teledrink_user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON teledrink.* TO 'teledrink_user'@'localhost';
FLUSH PRIVILEGES;
USE teledrink;

INSERT INTO Cocktail (name, category, instructions, imageUrl) VALUES
('Margarita', 'Coctel', 'Agitar todos los ingredientes con hielo y colar en un vaso frío.', 'https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg'),
('Mojito', 'Coctel', 'Macerar las hojas de menta con azúcar y jugo de lima. Añadir un poco de soda y llenar el vaso con hielo. Verter el ron sobre el hielo y completar con soda. Decorar y servir con una pajita.', 'https://www.thecocktaildb.com/images/media/drink/rxtqps1478251029.jpg'),
('Old Fashioned', 'Coctel', 'Macerar el azúcar con los amargos y agua. Añadir el bourbon y remover suavemente con hielo.', 'https://www.thecocktaildb.com/images/media/drink/vrwquq1478252802.jpg'),
('Cosmopolitan', 'Coctel', 'Agitar los ingredientes con hielo y colar en un vaso de cóctel frío. Decorar con un twist de lima.', 'https://www.thecocktaildb.com/images/media/drink/kpsajh1504368362.jpg'),
('Whiskey Sour', 'Coctel', 'Agitar con hielo. Colar en un vaso frío, decorar y servir.', 'https://www.thecocktaildb.com/images/media/drink/hbkfsh1589574990.jpg'),
('Mai Tai', 'Coctel', 'Agitar todos los ingredientes con hielo. Colar en un vaso old-fashioned.', 'https://www.thecocktaildb.com/images/media/drink/twyrrp1439907470.jpg'),
('Piña Colada', 'Coctel', 'Mezclar todos los ingredientes con hielo en una licuadora. Servir en un vaso frío decorado con una rodaja de piña y una cereza marrasquino.', 'https://www.thecocktaildb.com/images/media/drink/cpf4j51504371346.jpg'),
('Daiquiri', 'Coctel', 'Agitar todos los ingredientes con hielo y colar en un vaso de cóctel frío.', 'https://www.thecocktaildb.com/images/media/drink/mrz9091589574515.jpg'),
('Gin Tonic', 'Coctel', 'Añadir ginebra y tónica a un vaso alto lleno de hielo. Remover suavemente y decorar con una rodaja de lima.', 'https://www.thecocktaildb.com/images/media/drink/wx7hsg1504370510.jpg'),
('Bloody Mary', 'Coctel', 'Mezclar bien, verter sobre cubos de hielo en un vaso alto. Decorar y servir con una pajita.', 'https://www.thecocktaildb.com/images/media/drink/t6caa21582485702.jpg'),
('Negroni', 'Coctel', 'Remover los ingredientes con hielo y colar en un vaso de cóctel frío. Decorar con un twist de naranja.', 'https://www.thecocktaildb.com/images/media/drink/qgdu971561574065.jpg'),
('Tequila Sunrise', 'Coctel', 'Verter el tequila y el jugo de naranja en un vaso. Añadir granadina y dejar que se asiente antes de servir. Decorar con una cereza y una rodaja de naranja.', 'https://www.thecocktaildb.com/images/media/drink/quqyqp1480879103.jpg');

