db = db.getSiblingDB('escaperoom_logs_db');

// Crear usuario appuser con permisos solo en esta DB
db.createUser({
    user: "appuser",
    pwd: "app_pass",
    roles: [{ role: "readWrite", db: "escaperoom_logs_db" }]
});

// Insertar logs iniciales
db.logs.insertMany([
    {
        type: "STARTUP",
        message: "Servidor de Escape Room iniciado",
        level: "INFO",
        timestamp: new Date()
    },
    {
        type: "DATABASE",
        message: "Conexión a MySQL establecida correctamente",
        level: "INFO",
        timestamp: new Date()
    },
    {
        type: "DATABASE",
        message: "Conexión a MongoDB establecida correctamente",
        level: "INFO",
        timestamp: new Date()
    },
    {
        type: "EVENT",
        message: "Primer evento creado: 'Escape Room de Halloween'",
        level: "INFO",
        timestamp: new Date()
    }
]);
