import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms'; // Añadido FormControl y Validators
import { EventInput } from '@fullcalendar/core';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-cita-modal',
  templateUrl: './cita-modal.component.html',
  styleUrls: ['./cita-modal.component.css']
})
export class CitaModalComponent {
  citaForm: FormGroup;
  especialistas = ['Especialista 1', 'Especialista 2', 'Especialista 3'];
  consultorios = ['Consultorio 1', 'Consultorio 2', 'Consultorio 3'];
  turnos = ['08:00', '10:00', '12:00', '14:00', '16:00'];
  servicios = ['Servicio 1', 'Servicio 2', 'Servicio 3'];

  constructor(
    public dialogRef: MatDialogRef<CitaModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private formBuilder: FormBuilder
  ) {
    this.citaForm = this.formBuilder.group({
      paciente: [{ value: 'Jose Miguel Posada', disabled: true }], // Establecer el disabled en la creación del control
      servicio: [''],
      especialista: [''],
      consultorio: [''],
      fecha: [data.date],
      turno: ['']
    });
  }

  submitForm() {
    const servicio = this.citaForm.get('servicio')?.value;
    const fecha = this.citaForm.get('fecha')?.value;
    const turno = this.citaForm.get('turno')?.value;
  
    if (servicio && fecha && turno) {
      const fechaFormateada = formatDate(fecha, 'yyyy-MM-dd', 'en-US');
      const cita: EventInput = {
        title: servicio,
        start: `${fechaFormateada}T${turno}`
      };
      
      this.dialogRef.close(cita);
    }
  }
}