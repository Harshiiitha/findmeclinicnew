//package com.stackroute.repository;
//
//import com.stackroute.domain.Patient;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//
//
//@RunWith(SpringRunner.class)
//@EnableMongoRepositories(basePackages = "com.stackroute.repository")
//public class PatientRepositoryTest {
//
//    @Autowired
//    private  PatientRepository patientRepository;
//    private Patient patient;
//
//
//    @Before
//    public  void setUp()
//    {
//        patient=new Patient();
//        patient.setName("Harshitha");
//        patient.setDateOfBirth(new Date());
//        patient.setEmailId("harshi@gmail.com");
//        patient.setGender("female");
//        patient.setPhone("7842058626");
//        patient.setPassword("harshi");
//
//
//    }
//
//    @After
//    public void tearDown()
//    {
//
//        patientRepository.deleteAll();
//        patient=null;
//    }
//
//
//    @Test
//    public void testSavePatient() {
//
//        patientRepository.save(patient);
//        Patient fetchPatient = patientRepository.findById(patient.getEmailId()).get();
//        Assert.assertEquals("2", fetchPatient.getEmailId());
//
//    }
//
//
//    @Test
//    public void testSaveTrackFailure() {
//         Patient patient=new Patient();
//        patient.setName("Harshitha");
//        patient.setDateOfBirth(new Date());
//        patient.setEmailId("harshith@gmail.com");
//        patient.setGender("female");
//        patient.setPhone("7842058626");
//        patient.setPassword("harshi");
//      //
//        patientRepository.save(patient);
//        Patient fetchPatient = patientRepository.findById(patient.getEmailId()).get();
//        Assert.assertNotEquals(patient, fetchPatient);
//    }
//
//    @Test
//    public void testGetAllTracks() {
//        Patient patient=new Patient();
//        patient.setName("Harshitha");
//        patient.setDateOfBirth(new Date());
//        patient.setEmailId("harshitha@gmail.com");
//        patient.setGender("female");
//        patient.setPhone("7842058626");
//        patient.setPassword("harshi");
//        Patient patient1=new Patient();
//        patient1.setName("Shahina");
//        patient1.setDateOfBirth(new Date());
//        patient1.setEmailId("shahina shaik@gmail.com");
//        patient.setGender("female");
//        patient.setPhone("7842058626");
//        patient.setPassword("shahina");
//       patientRepository.save(patient);
//       patientRepository.save(patient1);
//
//        List<Patient> patientList = patientRepository.findAll();
//        Assert.assertEquals("Shahina",patientList.get(1).getName() );
//    }
//
//    @Test
//    public void testDeletePatient() {
//
//        Patient patient=new Patient();
//        patient.setName("Harshitha");
//        patient.setDateOfBirth(new Date());
//        patient.setEmailId("raju@gmail.com");
//        patient.setGender("female");
//        patient.setPhone("7842058626");
//        patient.setPassword("harshi");
//        patientRepository.save(patient);
//        patientRepository.deleteById(patient.getEmailId());
//        Optional optional = patientRepository.findById(patient.getEmailId());
//        Assert.assertEquals(Optional.empty(), optional);
//    }
//
//    @Test
//    public void testDeleteTrackFailure() {
//
//        Patient patient=new Patient();
//        patient.setName("Harshitha");
//        patient.setDateOfBirth(new Date());
//        patient.setEmailId("ram@gmail.com");
//        patient.setGender("female");
//        patient.setPhone("7842058626");
//        patient.setPassword("harshi");
//        patientRepository.save(patient);
//        patientRepository.deleteById(patient.getEmailId());
//        Optional optional = patientRepository.findById(patient.getEmailId());
//        boolean value = optional.isPresent();
//        Assert.assertNotEquals(Optional.empty(), value);
//    }
//
//}