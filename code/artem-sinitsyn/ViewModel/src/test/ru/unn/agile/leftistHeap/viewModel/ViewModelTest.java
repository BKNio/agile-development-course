package ru.unn.agile.leftistHeap.viewModel;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViewModelTest {
    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @Test
    public void areDefaultValuesCorrect() {
        assertEquals("0", viewModel.keyAdd);
        assertEquals("Zero", viewModel.valueAdd);
        assertEquals("", viewModel.keyGetDel);
        assertEquals("", viewModel.valueGetDel);
        assertEquals("OK", viewModel.status);
    }

    @Test
    public void cannotConvertInvalidInput(){
        viewModel.keyAdd = "-1";
        viewModel.valueAdd = null;
        viewModel.addToLeftistHeap();
        assertEquals("Invalid input", viewModel.status);
    }

    @Test
    public void canConvertValidInput(){
        viewModel.addToLeftistHeap();
        assertEquals("New element is successfully added", viewModel.status);
    }

    @Test
    public void canAddToLeftistHeap() {
        viewModel.addToLeftistHeap();
        assertEquals("New element is successfully added", viewModel.status);
    }

    @Test
    public void cannotGetMinFromEmptyHeap() {
        viewModel.getMinFromLeftistHeap();
        assertEquals("", viewModel.keyGetDel);
        assertEquals("", viewModel.valueGetDel);
        assertEquals("Cant get min from empty heap", viewModel.status);
    }

    @Test
    public void canGetMinFromHeap() {
        viewModel.addToLeftistHeap();
        viewModel.getMinFromLeftistHeap();
        assertEquals("0", viewModel.keyGetDel);
        assertEquals("Zero", viewModel.valueGetDel);
        assertEquals("Min is successfully got", viewModel.status);
    }

    @Test
    public void cannotDeleteMinFromEmptyHeap() {
        viewModel.deleteMinFromLeftistHeap();
        assertEquals("", viewModel.keyGetDel);
        assertEquals("", viewModel.valueGetDel);
        assertEquals("Cant delete min from empty heap", viewModel.status);
    }

    @Test
    public void canDeleteMinFromLeftistHeap() {
        viewModel.addToLeftistHeap();
        viewModel.deleteMinFromLeftistHeap();
        assertEquals("0", viewModel.keyGetDel);
        assertEquals("Zero", viewModel.valueGetDel);
        assertEquals("Min is successfully deleted", viewModel.status);
    }
}
