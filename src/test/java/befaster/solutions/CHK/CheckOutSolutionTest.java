package befaster.solutions.CHK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckOutSolutionTest {

    private CheckoutSolution checkoutSolution;

    @BeforeEach
    public void setup (){
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void compute_checkout(){
       assertThat(checkoutSolution.checkout("ABCD"), equalTo(115));
    }


}


