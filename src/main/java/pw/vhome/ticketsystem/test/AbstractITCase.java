//package pw.vhome.ticketsystem.test;
//
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.importer.ZipImporter;
//import org.jboss.shrinkwrap.api.spec.WebArchive;
//
//import java.io.File;
//
///**
// * Created by wvitz on 20.06.2017.
// */
//public abstract class AbstractITCase {
//
//    @Deployment(testable = false)
//    public static WebArchive createDeployment() {
//        WebArchive archive = ShrinkWrap
//                .create(ZipImporter.class, "test.war")
//                .importFrom(new File("target/my-aktion.war"))
//                .as(WebArchive.class);
//        return archive;
//    }
//}
