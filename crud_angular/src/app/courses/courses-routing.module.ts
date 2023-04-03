import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CourseFormComponent } from './containers/course-form/course-form.component';
import { CoursesComponent } from './containers/courses/courses.component';

const routes: Routes = [
  { path: '', component:CoursesComponent }, // verifica que não tem mais nada depois de: 'http://localhost4200/courses'
  { path: 'new', component:CourseFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoursesRoutingModule { }
