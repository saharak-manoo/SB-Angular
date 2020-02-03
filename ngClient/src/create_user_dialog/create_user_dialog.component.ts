import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Component, OnInit, Inject, ViewChild, ElementRef } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AppComponent } from '../app/app.component';

@Component({
  selector: 'app-confirm-dialog',
  templateUrl: './create_user_dialog.component.html'
})
export class CreateUserDialogComponent implements OnInit {
  createUserForm: FormGroup;
  isLoading: boolean = false;
  username: string = null;
  password: string = null;
  firstName: string = null;
  lastName: string = null;

  constructor(public dialogRef: MatDialogRef<CreateUserDialogComponent>) {}

  ngOnInit() {
    this.initForm();
  }

  hasError = (controlName: string, errorName: string) => {
    return this.createUserForm.controls[controlName].hasError(errorName);
  };

  initForm() {
    this.createUserForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      firstName: new FormControl('', [Validators.required]),
      lastName: new FormControl('', [Validators.required])
    });
  }

  onDismiss(): void {
    let data = {
      user: null,
      isCreate: true
    };
    this.dialogRef.close(data);
  }

  onSubmit() {
    if (this.createUserForm.invalid) {
      return;
    }
    this.isLoading = true;
    let params = {
      username: this.username,
      password: this.password,
      firstName: this.firstName,
      lastName: this.lastName
    };
    let data = {
      user: params,
      isCreate: true
    };

    this.dialogRef.close(data);
  }
}

// export class CreateUserDialogModal {
//   constructor(public title: string) {}
// }
