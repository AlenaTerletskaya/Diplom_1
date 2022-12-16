import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

// Тесты модели бургера (класс Burger)
public class BurgerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Burger mockBurger;

    @Spy
    Burger spyBurger;

    @Mock
    Bun mockBun;

    @Mock
    Ingredient mockIngr;

    @Mock
    Ingredient mockIngr2;

    // Проверяем, что метод setBuns(Bun bun) вызван 1 раз, c указанным аргументом.
    @Test
    public void checkBurgerSetBuns_calledOnceWithArg() {
        mockBurger.setBuns(mockBun);
        Mockito.verify(mockBurger).setBuns(mockBun);
    }

    // Проверяем, что при вызове метода с аргуметом setBuns(Bun bun)
    // значение аргумента сохраняется в переменную bun.
    @Test
    public void checkBurgerSetBuns_expectArgSaveToBun() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        Assert.assertEquals("The bun should be equal to mockBun", mockBun, burger.bun);
    }

    // Проверяем, что метод addIngredient(Ingredient ingredient) вызван 1 раз, c указанным аргументом.
    @Test
    public void checkBurgerAddIngr_calledOnceWithArg() {
        mockBurger.addIngredient(mockIngr);
        Mockito.verify(mockBurger).addIngredient(mockIngr);
    }

    // Проверяем, что при вызове метода с аргуметом addIngredient(Ingredient ingredient)
    // значение аргумента добавляется в список ингредиентов (ingredients).
    @Test
    public void checkBurgerAddIngr_expectAddIngrToList() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngr);
        Assert.assertEquals("The size of the ingredients list should be equal to 1",
                1, burger.ingredients.size());
        Assert.assertEquals("The ingredient in the list should be equal to mockIngredient",
                mockIngr, burger.ingredients.get(0));
    }

    // Проверяем, что метод removeIngredient(int index) вызван 1 раз, c указанным аргументом.
    @Test
    public void checkBurgerRemoveIngr_calledOnceWithArg() {
        mockBurger.removeIngredient(2);
        Mockito.verify(mockBurger).removeIngredient(2);
    }

    // Проверяем, что при вызове метода с аргуметом removeIngredient(int index)
    // ингредиент с данным индексом удаляется из списка ингредиентов (ingredients).
    @Test
    public void checkBurgerRemoveIngr_expectDeleteIngrFromList() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngr);
        burger.removeIngredient(0);
        Assert.assertEquals("The size of the ingredients list should be equal to 0",
                0, burger.ingredients.size());
    }

    // Проверяем, что метод moveIngredient(int index, int newIndex) вызван 1 раз, c указанными аргументами.
    @Test
    public void checkBurgerMoveIngr_calledOnceWithArgs() {
        mockBurger.moveIngredient(3, 1);
        Mockito.verify(mockBurger).moveIngredient(3, 1);
    }

    // Проверяем, что при вызове метода с аргуметами moveIngredient(int index, int newIndex)
    // ингредиент с индексом index перемещается в списке ингредиентов (ingredients)
    // на место, соответствующее новому индексу newIndex.
    @Test
    public void checkBurgerMoveIngr_expectMoveIngrToNewIndexInList() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngr);
        burger.addIngredient(mockIngr2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("An ingredient with index 0 should be equal to " + mockIngr2,
                mockIngr2, burger.ingredients.get(0));
        Assert.assertEquals("An ingredient with index 1 should be equal to " + mockIngr,
                mockIngr, burger.ingredients.get(1));
    }

    // Проверяем, что метод getPrice() вызван 1 раз.
    @Test
    public void checkBurgerGetPrice_calledOnce() {
        mockBurger.getPrice();
        Mockito.verify(mockBurger).getPrice();
    }

    // Проверяем, что если бургер с булочкой (по цене 100) и двумя ингридиентами (по цене 30 и 50),
    // то метод getPrice() возвращает цену бургера = 280.
    @Test
    public void checkBurgerGetPrice_BunAndTwoIngr_returnBurgerPrice() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngr);
        burger.addIngredient(mockIngr);
        Mockito.when(mockBun.getPrice()).thenReturn(100f);
        Mockito.when(mockIngr.getPrice()).thenReturn(30f, 50f);
        float expectedPrice = 280f;
        Assert.assertEquals("The burger price should be equal to" + expectedPrice,
                expectedPrice, burger.getPrice(), 0.001);
    }

    // Проверяем, что если бургер только с булочкой (по цене 100) без ингридиентов,
    // то метод getPrice() возвращает цену бургера = 200.
    @Test
    public void checkBurgerGetPrice_BunNoIngr_returnBurgerPrice() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        Mockito.when(mockBun.getPrice()).thenReturn(100f);
        float expectedPrice = 200f;
        Assert.assertEquals("The burger price should be equal to" + expectedPrice,
                expectedPrice, burger.getPrice(), 0.001);
    }

    // Проверяем, что метод getReceipt() вызван 1 раз.
    @Test
    public void checkBurgerGetReceipt_calledOnce() {
        mockBurger.getReceipt();
        Mockito.verify(mockBurger).getReceipt();
    }

    // Проверяем, что метод getReceipt() возвращает квитанцию определенного вида.
    @Test
    public void checkBurgerGetReceipt_returnExpectedReceipt() {
        spyBurger.setBuns(mockBun);
        spyBurger.addIngredient(mockIngr);
        Mockito.when(mockBun.getName()).thenReturn("black bun");
        Mockito.when(mockIngr.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(mockIngr.getName()).thenReturn("sour cream");
        Mockito.when(spyBurger.getPrice()).thenReturn(350f);
        String expectedReceipt = String.format(
                "(==== black bun ====)%n" +
                "= sauce sour cream =%n" +
                "(==== black bun ====)%n" +
                "%nPrice: 350,000000%n");
        Assert.assertEquals("The receipt should be equal to: \n" + expectedReceipt,
                expectedReceipt, spyBurger.getReceipt());
    }
}
