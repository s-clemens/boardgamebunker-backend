package nl.novi.clemens.bgbbackend.service;

import nl.novi.clemens.bgbbackend.domain.BoardgameType;
import nl.novi.clemens.bgbbackend.domain.enums.EBoardgameType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductserviceImplTest {

    @Test
    public void boardgameTypeToStringTest(){
        // Arrange
        BoardgameType boardgameType1 = new BoardgameType();
        boardgameType1.setName(EBoardgameType.TWO_HOURS);

        BoardgameType boardgameType2 = new BoardgameType();
        boardgameType2.setName(EBoardgameType.THIRTY_MINUTES);

        ProductServiceImpl productService = new ProductServiceImpl();

        // Act
        String testString1 = productService.boardgameTypeToString(boardgameType1);
        String testString2 = productService.boardgameTypeToString(boardgameType2);

        // Assert
        assert(testString1.equals("2 uur") && testString2.equals("30 minuten"));
    }
}
