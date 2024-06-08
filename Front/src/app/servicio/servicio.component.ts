import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Dato, IServicio } from '../models/servicio.model';
import { ServicioHttpService } from './servicio-http.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-servicio',
  templateUrl: './servicio.component.html',
  styleUrls: ['./servicio.component.css']
})
export class ServicioComponent implements OnInit {

  servicioList: Dato[] = [];
  servicioForm: FormGroup;

  constructor(
    private fb: FormBuilder, 
    private _apiService: ServicioHttpService,
    private toastr: ToastrService
  ) {
    this.servicioForm = this.fb.group({
      nombreServicio: ['', Validators.required],
      duracionEstimada: ['', [Validators.required, Validators.min(1)]],
      descripcion: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this._apiService.getServicios().subscribe((response: IServicio) => {
      this.servicioList = response.datos;
    });
  }

  onSubmit(): void {
    if (this.servicioForm.valid) {
      const nuevoServicio: Dato = this.servicioForm.value;
      this._apiService.postServicios(nuevoServicio).subscribe((response: IServicio) => {
        if (response.datos.length > 0) {
          this.servicioList.push(response.datos[0]);
          this.servicioForm.reset();
          this.toastr.success('El servicio se creó correctamente.', 'Éxito', {
            positionClass: 'toast-center-center'
          });
        } else {
          this.toastr.error('No se pudo crear el servicio.', 'Error', {
            positionClass: 'toast-center-center'
          });
        }
      });
    } else {
      this.toastr.error('Por favor complete todos los campos del formulario.', 'Error', {
        positionClass: 'toast-center-center'
      });
    }
  }
}
