import by.shpak.laba1.service.CylinderService;
import org.junit.Assert;
import org.junit.Test;

public class TestCylinderVolume {
    @Test
    public void testVolume() throws Exception{
        CylinderService cylinder = new CylinderService();
        Assert.assertEquals(3.14, cylinder.calculateVolume(1,1), 0.0001);
    }
}
