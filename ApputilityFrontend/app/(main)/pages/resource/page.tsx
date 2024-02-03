/* eslint-disable @next/next/no-img-element */
'use client';
import { Button } from 'primereact/button';
import { Column } from 'primereact/column';
import { DataTable } from 'primereact/datatable';
import { Dialog } from 'primereact/dialog';
import { FileUpload } from 'primereact/fileupload';
import { InputText } from 'primereact/inputtext';
import { Toast } from 'primereact/toast';
import { Toolbar } from 'primereact/toolbar';
import { classNames } from 'primereact/utils';
import React, { useEffect, useRef, useState, useMemo } from 'react';
import { ResourceService } from 'service/ResourceService';
import { Project } from '@/types';

// Componentes and components
const CrudResource = () => {
    let emptyResource: Project.Resource = {
        id: 0,
        name: '',
        key: ''
    };

    const [resources, setResources] = useState<Project.Resource[] | null>(null);
    const [resourceDialog, setResourceDialog] = useState(false);
    const [deleteResourceDialog, setDeleteResourceDialog] = useState(false);
    const [deleteResourcesDialog, setDeleteResourcesDialog] = useState(false);
    const [resource, setResource] = useState<Project.Resource>(emptyResource);
    const [selectedResources, setSelectedResources] = useState(null);
    const [submitted, setSubmitted] = useState(false);
    const [globalFilter, setGlobalFilter] = useState('');
    const toast = useRef<Toast>(null);
    const dt = useRef<DataTable<any>>(null);
    const resourceService = useMemo(() => new ResourceService(), []);

    useEffect(() => {
        if(!resources){
            resourceService.getAll()
            .then((response) => {
                console.log(response.data);
                setResources(response.data);
            })
            .catch((error) => {
                console.log(error);
            });

        }
    }, [resourceService, resources]);

    const openNew = () => {
        setResource(emptyResource);
        setSubmitted(false);
        setResourceDialog(true);
    };

    const hideDialog = () => {
        setSubmitted(false);
        setResourceDialog(false);
    };

    const hideDeleteResourceDialog = () => {
        setDeleteResourceDialog(false);
    };

    const hideDeleteResourcesDialog = () => {
        setDeleteResourcesDialog(false);
    };

    const saveResource = () => {
        setSubmitted(true);

        // TODO: Validation
        if (!resource.id) {
            resourceService.save(resource).then((response) => {
                console.log(response.data);
                setResourceDialog(false);// se o usuário foi criado, o dialogo será fechado.
                setResource(emptyResource); // Limpa o formulário.
                setResources(null);
                toast.current?.show({ severity: 'info', summary: 'Successo', detail: 'Utilizador criado com sucesso!' });// Se o usuário não foi criado, o toast será fechado.
            }).catch((error) => {
                console.log(error.data.message);
                toast.current.show({ severity: 'error', summary: 'Error', detail: 'Erro ao criar utilizador! ' + error.data.message });
            });
        } else {
            resourceService.update(resource).then((response) => {
                console.log(response.data);
                setResourceDialog(false);// se o utilizador foi atualizado, o dialogo será fechado.
                setResources( null);
                toast.current?.show({ severity: 'info', summary: 'Successo', detail: 'Utilizador atualizado com sucesso!' });// Se o utilizador não foi atualizado, o toast será fechado.
            }).catch((error) => {
                console.log(error.data.message);
                toast.current.show({ severity: 'error', summary: 'Error', detail: 'Erro ao atualizar utilizador!'+ error.data.message });
            });
        }
        
    }; 

    const editResource = (resource: Project.resource) => {
        setResource({ ...resource });
        setResourceDialog(true);
    };

    const confirmDeleteResource = (resource: Project.resource) => {
        setResource(resource);
        setDeleteResourceDialog(true);
    };

    const deleteResource = () => {
        if(resource.id){
            resourceService.delete(resource.id).then((response) => { 
            setResource(emptyResource); // Limpa o formulário.    
            setResources(null);           
            setDeleteResourceDialog(false);// se o usuário foi eliminado, o dialogo será fechado.            
            toast.current?.show({ severity: 'success', summary: 'Successo!', detail: 'Utilizador eliminado com sucesso!', life:3000 }); // Se o utilizador não foi excluído, o toast será fechado.
                
            }).catch((error) => {
                console.log(error.data.message);
                toast.current?.show({ severity: 'error', summary: 'Erro!', detail: 'Erro ao eliminar utilizador!'+ error.data.message, life: 3000 }); // Se o utilizador não foi excluído, o toast será fechado.
            })
        }; 
        
    };

    // Método responsável por buscar um utilizador pelo seu login.
    const findIndexById = (id: string) => {
        let index = -1;
        for (let i = 0; i < (resources as any)?.length; i++) {
            if ((resources as any)[i].id === id) {
                index = i;
                break;
            }
        }

        return index;
    }; 

    // Método responsável por gerar ficheiros CSV dos Recursos.
    const exportCSV = () => {
        dt.current?.exportCSV();
    };

    // Confirmação de exclusão do Recurso.
    const confirmDeleteSelected = () => {
        setDeleteResourcesDialog(true);
    };

    // Elimina utilizadores Recursos.
    const deleteSelectedResources = () => {
        let _resources = (resources as any)?.filter((val: any) => !(selectedResources as any)?.includes(val));
        setResources(_resources);
        setDeleteResourcesDialog(false);
        setSelectedResources(null);
        toast.current?.show({
            severity: 'success',
            summary: 'Successo!',
            detail: 'Os Utilizadores selecionados foram eliminados com sucesso!',
            life: 3000
        }); 
    };

    
    const onInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        let _resource = { ...resource };
        _resource[`${name}`] = val;

        setResource(_resource);
    };

    /* const onInputNumberChange = (e: InputNumberValueChangeEvent, name: string) => {
        const val = e.value || 0;
        let _resource = { ...resource };
        _resource[`${name}`] = val;

        setResource(_resource);
    }; */ 

    // Modal de confirmação de exclusão de utilizador.
    const leftToolbarTemplate = () => {
        return (
            <React.Fragment>
                <div className="my-2">
                    <Button label="Novo" icon="pi pi-plus" severity="success" className=" mr-2" onClick={openNew} />
                    <Button label="Apagar" icon="pi pi-trash" severity="danger" onClick={confirmDeleteSelected} disabled={!selectedResources || !(selectedResources as any).length} />
                </div>
            </React.Fragment>
        );
    };

    //Exportação de ficheiros CSV dos recusos.
    const rightToolbarTemplate = () => {
        return (
            <React.Fragment>
                <FileUpload mode="basic" accept="image/*" maxFileSize={1000000} chooseLabel="Import" className="mr-2 inline-block" />
                <Button label="Export" icon="pi pi-upload" severity="help" onClick={exportCSV} />
            </React.Fragment>
        );
    };

    const idBodyTemplate = (rowData: Project.Resource) => {
        return (
            <>
                <span className="p-column-title">Código</span>
                {rowData.id}
            </>
        );
    };

    const nameBodyTemplate = (rowData: Project.Resource) => {
        return (
            <>
                <span className="p-column-title">Nome</span>
                {rowData.name}
            </>
        );
    };

    const actionBodyTemplate = (rowData: Project.Resource) => {
        return (
            <>
                <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={() => editResource(rowData)} />
                <Button icon="pi pi-trash" rounded severity="warning" onClick={() => confirmDeleteResource(rowData)} />
            </>
        );
    };

    const keyNameBodyTemplate = (rowData: Project.Resource) => {
        return (
            <>
                <span className="p-column-title">Chave</span>
                {rowData.key}
            </>
        );
    };

    /* const emailBodyTemplate = (rowData: Project.Resource) => {
        return (
            <>
                <span className="p-column-title">Email</span>
                {rowData.email}
            </>
        );
    }; */

    const header = (
        <div className="flex flex-column md:flex-row md:justify-content-between md:align-items-center">
            <h5 className="m-0">Gestão de Recursos de Utilizador</h5>
            <span className="block mt-2 md:mt-0 p-input-icon-left">
                <i className="pi pi-search" />
                <InputText type="search" onInput={(e) => setGlobalFilter(e.currentTarget.value)} placeholder="Buscar..." />
            </span>
        </div>
    );

    const resourceDialogFooter = (
        <>
            <Button label="Cancelar" icon="pi pi-times" text onClick={hideDialog} />
            <Button label="Guardar" icon="pi pi-check" text onClick={saveResource} />
        </>
    );
    const deleteResourceDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteResourceDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteResource} />
        </>
    );
    const deleteResourcesDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteResourcesDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteSelectedResources} />
        </>
    );

    return (
        <div className="grid crud-demo">
            <div className="col-12">
                <div className="card">
                    <Toast ref={toast} />
                    <Toolbar className="mb-4" left={leftToolbarTemplate} right={rightToolbarTemplate}></Toolbar>

                    <DataTable
                        ref={dt}
                        value={resources}
                        selection={selectedResources}
                        onSelectionChange={(e) => setSelectedResources(e.value as any)}
                        dataKey="id"
                        paginator
                        rows={10}
                        rowsPerPageOptions={[5, 10, 25]}
                        className="datatable-responsive"
                        paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
                        currentPageReportTemplate="Mostra {first} a {last} de {totalRecords} Utilizadores"
                        globalFilter={globalFilter}
                        emptyMessage="Nenhum utilizador encontrado."
                        header={header}
                        responsiveLayout="scroll">
                        <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}></Column>
                        <Column field="id" header="Código" sortable body={idBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column field="name" header="Nome" sortable body={nameBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column field="key" header="Key" sortable body={keyNameBodyTemplate} headerStyle={{ minWidth: '15rem'}}></Column>
                       {/*  <Column field="email" header="Email" sortable body={emailBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column> */}
                        <Column body={actionBodyTemplate} headerStyle={{ minWidth: '10rem' }}></Column>
                    </DataTable>

                    <Dialog visible={resourceDialog} style={{ width: '450px' }} header="Detalhes do Recurso" modal className="p-fluid" footer={resourceDialogFooter} onHide={hideDialog}>
                        <div className="field">
                            <label htmlFor="name">Nome</label>
                            <InputText
                                id="name"
                                value={resource.name}
                                onChange={(e) => onInputChange(e, 'name')}
                                required
                                autoFocus
                                className={classNames({
                                    'p-invalid': submitted && !resource.name
                                })}
                            />
                            {submitted && !resource.name && <small className="p-invalid">O Nome é obrigatório.</small>}
                        </div>
                          

                        <div className="field">
                            <label htmlFor="key">Chave</label>
                            <InputText
                                id="key"
                                value={resource.key}
                                onChange={(e) => onInputChange(e, 'key')}
                                required
                                autoFocus
                                className={classNames({
                                    'p-invalid': submitted && !resource.key
                                })}
                            />
                            {submitted && !resource.key && <small className="p-invalid">A Chave é obrigatória.</small>}
                        </div>                        
                    </Dialog>

                    <Dialog visible={deleteResourceDialog} style={{ width: '450px' }} header="Confirmar" modal footer={deleteResourceDialogFooter} onHide={hideDeleteResourceDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {resource && (
                                <span>
                                    Você tem a certeza que pretende eliminar o recurso <b>{resource.name}</b>?
                                </span>
                            )}
                        </div>
                    </Dialog>

                    <Dialog visible={deleteResourcesDialog} style={{ width: '450px' }} header="Confirmar" modal footer={deleteResourcesDialogFooter} onHide={hideDeleteResourcesDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {resource && <span>Você tem a certeza que pretende eliminar os recursos selecionados?</span>}
                        </div>
                    </Dialog>
                </div>
            </div>
        </div>
    );
};

export default CrudResource;
