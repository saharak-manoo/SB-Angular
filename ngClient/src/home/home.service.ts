import { Injectable, isDevMode } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { environment } from '../environments/environment';

@Injectable()
export class HomeService {
  constructor(protected http: HttpClient) {}

  getUsers() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json;',
      Authorization: `Bearer ${localStorage.getItem('token')}`
    });

    return this.http.get(`${environment.host}/api/v1/users`, {
      headers: headers
    });
  }
}
