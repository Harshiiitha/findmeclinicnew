import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Patient } from '../Patient';
import { BookAppointment } from '../bookappointment';
import { Doctor } from '../doctor';
import { AppointmentService } from '../appointment.service';
import { ConfirmationDialogComponent } from '../confirmation-dialog/confirmation-dialog.component';
import { MatDialog } from '@angular/material';
import { SchedulerService } from '../scheduler.service';

@Component({
  selector: 'app-confirmbooking',
  templateUrl: './confirmbooking.component.html',
  styleUrls: ['./confirmbooking.component.css']
})

export class ConfirmbookingComponent implements OnInit {
    registerForm: FormGroup;
    submitted = false;
    name: string;
    clinicName:string;
    emailId:string;
    address1:string;
    area:string;
    // appointmentDate:Date;
    appointmentId:number;
    slot:string;
    id:string;
    doctor=new Doctor();
    address: any = {}
    patient=new Patient();
    key:string;
    bookAppointment=new BookAppointment();
   

    constructor(private formBuilder: FormBuilder,private route:ActivatedRoute,private appointment:AppointmentService,public dialog: MatDialog,private schedulerService:SchedulerService) {
        this.route.queryParams.subscribe(params => {
            this.name = params["name"];
            this.clinicName = params["clinicName"];
            this.emailId = params["emailId"];
            this.address1 = params["address"];
            this.area = params["area"];
            //this.appointmentDate=params["appointmentDate"];
            this.slot=params["slot"];
            this.appointmentId=params["appointmentId"];
            this.key=params["key"];
        });
          this.id="EBRYS"+Math.floor(Math.random() * 123) + 1
         
     }

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            firstName: ['', Validators.required],
            date: ['', Validators.required],
            phone: ['',[Validators.required, Validators.maxLength(10), Validators.minLength(10)]],
            gender: ['', Validators.required],
            email: ['',[Validators.required, Validators.email]],
        });
    }

    register()
    {
       this.patient.name=this.registerForm.controls.firstName.value;
       this.patient.phone=this.registerForm.controls.phone.value;
       this.patient.emailId=this.registerForm.controls.email.value;
       this.patient.dateOfBirth=this.registerForm.controls.date.value;
     
      console.log(this.patient);
      
       
    }
    // convenience getter for easy access to form fields
    get f() { return this.registerForm.controls; }

    onSubmit() {
        this.submitted = true;
        this.findInvalidControls();
    }

   
    findInvalidControls() {
        console.log("hii");
        const invalid = [];
        const controls = this.registerForm.controls;
        for (const name in controls) {
            if (controls[name].invalid) {
                invalid.push(name);
            }
        }
        console.log(invalid);
        if(invalid.length==0)
        { 
          this.doctor.name=this.name;
          this.doctor.clinicName=this.clinicName;
          this.doctor.emailId=this.emailId;
          this.address.address=this.address1;
          this.address.area=this.area;
          this.doctor.address = this.address;
          this.bookAppointment.doctor=this.doctor;
          this.bookAppointment.slot=this.slot;
          this.bookAppointment.appointmentId=this.appointmentId;
          this.bookAppointment.key=this.key;
          this.bookAppointment.patient=this.patient;
          this.bookAppointment.id=this.id;
          sessionStorage.setItem('appointmentid',this.appointmentId+"");
          sessionStorage.setItem('key',this.key);

          

          
          console.log(this.bookAppointment);
          
            this.appointment.saveAppointment(this.bookAppointment).subscribe(data =>{
            console.log(data);
                 }
               );
               const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
                width: '350px',
              
                disableClose: true,
               
              });
          
              dialogRef.afterClosed().subscribe(result => {
                console.log('The dialog was closed');
              });
        }
        else
        {
          return;
        }
      }
}
