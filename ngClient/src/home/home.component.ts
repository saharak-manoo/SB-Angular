import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HomeService } from './home.service';
import { MatDialog } from '@angular/material';
import { CreateUserDialogComponent } from '../create_user_dialog/create_user_dialog.component';

@Component({
  selector: 'app-root',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: [HomeService]
})
export class HomeComponent {
  constructor(private route: ActivatedRoute, private router: Router, private homeService: HomeService, public dialog: MatDialog) {}
  isLoading: boolean = true;
  users: any = [];

  ngOnInit() {
    this.getUser();
  }

  getUser() {
    this.isLoading = true;
    this.homeService.getUsers().subscribe(
      resp => {
        let data: any = resp;
        this.users = data.users;
        this.isLoading = false;
        console.log(this.users);
      },
      e => {
        this.isLoading = false;
        console.log(e);
      }
    );
  }

  openDialogCreateUser() {
    console.log('>>>>>>>');
    const dialogRef = this.dialog.open(CreateUserDialogComponent, {
      maxWidth: '800px',
      disableClose: true
    });
  }
}
