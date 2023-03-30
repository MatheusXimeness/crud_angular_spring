import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, first, tap } from 'rxjs/operators';

import { Course } from '../model/course';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private readonly API = 'api/courses/';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Course[]>(this.API) // esse é um observable que retorna um array de Courses
    .pipe(
      first(), // pega o primeiro dado que o endpoint retornar e encerra a conexão
      tap(courses => console.log(courses))
    );
  }

  save(record: Course) {
    return this.httpClient.post<Course>(this.API, record)
    .pipe(first());
  }
}
