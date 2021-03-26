import by.shpak.laba1.domain.CylinderVolume;
import org.junit.Assert;
import org.junit.Test;

public class TestCylinderVolume {
    @Test
    public void testVolume() throws Exception{
        CylinderVolume cylinder = new CylinderVolume(1,1);
        Assert.assertEquals(3.14, cylinder.getValue(), 0.0001);
    }
}
