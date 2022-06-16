package com.techelevator;

import com.techelevator.Inventory.Candy;
import com.techelevator.Inventory.Chip;
import com.techelevator.Inventory.Drink;
import com.techelevator.Inventory.Gum;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class DispensingMsgTest {

    @Test
    public void candy_returns_correct_msg() {
        Candy candy = new Candy("Moonpie", BigDecimal.valueOf(1.80));   //double

        String newString = candy.getDispensingMsg();

        Assert.assertEquals("Candy returns correct msg", "Munch Munch, Yum!", newString);
    }

    @Test
    public void chip_returns_correct_msg() {
        Chip chip = new Chip("Potato Crisps", BigDecimal.valueOf(3.05));   //double

        String newString = chip.getDispensingMsg();

        Assert.assertEquals("chip returns correct msg", "Crunch Crunch, Yum!", newString);
    }

    @Test
    public void drink_returns_correct_msg() {
        Drink drink = new Drink("Cola", BigDecimal.valueOf(1.25));   //double

        String newString = drink.getDispensingMsg();

        Assert.assertEquals("drink returns correct msg", "Glug Glug, Yum!", newString);
    }

    @Test
    public void gum_returns_correct_msg() {
        Gum gum = new Gum("U-Chews", BigDecimal.valueOf(0.85));   //double

        String newString = gum.getDispensingMsg();

        Assert.assertEquals("gum returns correct msg", "Chew Chew, Yum!", newString);
    }

}
