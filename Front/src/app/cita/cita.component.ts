import { Component, ChangeDetectorRef } from '@angular/core';
import { CalendarOptions, EventInput } from '@fullcalendar/core';
import interactionPlugin, { DateClickArg } from '@fullcalendar/interaction';
import dayGridPlugin from '@fullcalendar/daygrid';
import { CitaModalComponent } from '../cita-modal/cita-modal.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-cita',
  templateUrl: './cita.component.html',
  styleUrls: ['./cita.component.css']
})
export class CitaComponent {
  calendarOptions: CalendarOptions;
  calendarApi: any;

  constructor(public dialog: MatDialog, private cdRef: ChangeDetectorRef) {
    this.calendarOptions = {
      initialView: 'dayGridMonth',
      plugins: [dayGridPlugin, interactionPlugin],
      dateClick: (arg) => this.handleDateClick(arg),
      events : [{
        title: 'Servicio prueba',
        start: '2024-05-24'
      }],
      displayEventTime: false,
      eventDidMount: (info) => {
        this.calendarApi = info.view.calendar;
      }
    };
  }

  handleDateClick(arg: DateClickArg) {
    this.openDialog(arg.date);
  }

  openDialog(date: Date): void {
    const dialogRef = this.dialog.open(CitaModalComponent, {
      data: { date: date }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('El diálogo se cerró. Resultado:', result);
      if (result) {
        this.calendarApi.addEvent(result);
      }
    });
  }
}