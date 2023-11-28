import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import {
  AccordionModule,
  ButtonModule,
  CardModule,
  ConfirmDialogModule,
  DataViewModule,
  DialogModule,
  InputTextModule,
  TableModule,
  AutoCompleteModule,
  PasswordModule,
  InputMaskModule,
  TooltipModule,
  KeyFilterModule,
} from 'primeng';
import { BreadcrumbModule } from 'primeng/breadcrumb';
import { DynamicDialogModule } from 'primeng/dynamicdialog';
import { MenuModule } from 'primeng/menu';
import { PaginatorModule } from 'primeng/paginator';
import { PickListModule } from 'primeng/picklist';
import { ToastModule } from 'primeng/toast';
import { RadioButtonModule } from 'primeng/radiobutton';

const modules = [
  ButtonModule,
  CardModule,
  InputTextModule,
  BreadcrumbModule,
  MenuModule,
  PaginatorModule,
  PickListModule,
  ToastModule,
  DataViewModule,
  TableModule,
  DynamicDialogModule,
  AccordionModule,
  ConfirmDialogModule,
  DialogModule,
  RadioButtonModule,
  AutoCompleteModule,
  PasswordModule,
  InputMaskModule,
  TooltipModule,
  KeyFilterModule
];


@NgModule({
  declarations: [],
  imports: [CommonModule, ...modules],
  exports: [...modules],
})
export class PrimengModule {}
