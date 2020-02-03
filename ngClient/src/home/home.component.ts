import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HomeService } from './home.service';

@Component({
  selector: 'app-root',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: [HomeService]
})
export class HomeComponent {
  constructor(private route: ActivatedRoute, private router: Router, private homeService: HomeService) {}
  users: any = []

  ngOnInit() {
    this.homeService.getUsers().subscribe(
      resp => {
        let data: any = resp;
        this.users = data.users;
        console.log(this.users)
      },
      e => {
        console.log(e);
      }
    );
  }
}
