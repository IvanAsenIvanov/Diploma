# start

## Milestone 1
CLI application for task (OS processes) management.

-CRUD on Task objects (id, content - the input will be file path, description) persisted as json(gson,Jackson-databind)

-Logging of task manager + process output (log4j) – you should log information which can be important when you want to debug your application

-Interactive process input – command line application should be interactive and allow user to choose what operation should be executed

## CRUD definition
C-write path and name of task,rest of the process is automatically created

R-user picks from already created tasks

U-update date,state/apply changes to log

D-ask if really wants to delete the task y/n
