export interface IServicio {
    mensajes: string[];
    datos:    Dato[];
}

export interface Dato {
    id:               number;
    nombreServicio:   string;
    duracionEstimada: number;
    descripcion:      string;
}
