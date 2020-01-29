import { Component } from '@angular/core';
import { MatSnackBar, ErrorStateMatcher } from '@angular/material';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(public snackBar: MatSnackBar) {}

  ngOnInit() {}

  showSnackBar(message, action, className) {
    this.snackBar.open(message, action, {
      duration: 5000,
      panelClass: [className],
      verticalPosition: 'top',
      horizontalPosition: 'right'
    });
  }
}
