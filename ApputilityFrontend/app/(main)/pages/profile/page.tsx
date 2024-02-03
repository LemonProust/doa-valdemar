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
import { ProfileService } from 'service/ProfileService';
import { Project } from '@/types';

// Componentes and components
const CrudProfile = () => {
    let emptyProfile: Project.Profile = {
        id: 0,
        description: '',
        key: ''
    };

    const [profiles, setProfiles] = useState<Project.Profile[] | null>(null);// array de perfis que pode ser nulo
    const [profileDialog, setProfileDialog] = useState(false);
    const [deleteProfileDialog, setDeleteProfileDialog] = useState(false);
    const [deleteProfilesDialog, setDeleteProfilesDialog] = useState(false);
    const [profile, setProfile] = useState<Project.Profile>(emptyProfile);
    const [selectedProfiles, setSelectedProfiles] = useState(null);
    const [submitted, setSubmitted] = useState(false);
    const [globalFilter, setGlobalFilter] = useState('');
    const toast = useRef<Toast>(null);
    const dt = useRef<DataTable<any>>(null);
    const profileService = useMemo(() => new ProfileService(), []);

    useEffect(() => {
        if(!profiles){ // Caso o array de perfis esteja vazio
            profileService.getAll()
            .then((response) => {
                console.log(response.data);
                setProfiles(response.data);
            })
            .catch((error) => {
                console.log(error);
            });

        }
    }, [profileService, profiles]);

    const openNew = () => {
        setProfile(emptyProfile);
        setSubmitted(false);
        setProfileDialog(true);
    };

    const hideDialog = () => {
        setSubmitted(false);
        setProfileDialog(false);
    };

    const hideDeleteProfileDialog = () => {
        setDeleteProfileDialog(false);
    };

    const hideDeleteProfilesDialog = () => {
        setDeleteProfilesDialog(false);
    };

    const saveProfile = () => {
        setSubmitted(true);

        // TODO: Validation
        if (!profile.id) {
            profileService.save(profile).then((response) => {
                console.log(response.data);
                setProfileDialog(false);// se o usuário foi criado, o dialogo será fechado.
                setProfile(emptyProfile); // Limpa o formulário.
                setProfiles(null);
                toast.current?.show({ severity: 'info', summary: 'Successo', detail: 'Utilizador criado com sucesso!' });// Se o usuário não foi criado, o toast será fechado.
            }).catch((error) => {
                console.log(error.data.message);
                toast.current.show({ severity: 'error', summary: 'Error', detail: 'Erro ao criar utilizador! ' + error.data.message });
            });
        } else {
            profileService.update(profile).then((response) => {
                console.log(response.data);
                setProfileDialog(false);// se o utilizador foi atualizado, o dialogo será fechado.
                setProfiles(null);
                toast.current?.show({ severity: 'info', summary: 'Successo', detail: 'Utilizador atualizado com sucesso!' });// Se o utilizador não foi atualizado, o toast será fechado.
            }).catch((error) => {
                console.log(error.data.message);
                toast.current.show({ severity: 'error', summary: 'Error', detail: 'Erro ao atualizar utilizador!'+ error.data.message });
            });
        }
        
    }; 

    const editProfile = (profile: Project.profile) => {
        setProfile({ ...profile });
        setProfileDialog(true);
    };

    const confirmDeleteProfile = (profile: Project.profile) => {
        setProfile(profile);
        setDeleteProfileDialog(true);
    };

    const deleteProfile = () => {
        if(profile.id){
            profileService.delete(profile.id).then((response) => { 
            setProfile(emptyProfile); // Limpa o formulário.    
            setProfiles(null);           
            setDeleteProfileDialog(false);// se o usuário foi eliminado, o dialogo será fechado.            
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
        for (let i = 0; i < (profiles as any)?.length; i++) {
            if ((profiles as any)[i].id === id) {
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
        setDeleteProfilesDialog(true);
    };

    // Elimina utilizadores Recursos.
    const deleteSelectedProfiles = () => {
        let _profiles = (profiles as any)?.filter((val: any) => !(selectedProfiles as any)?.includes(val));
        setProfiles(_profiles);
        setDeleteProfilesDialog(false);
        setSelectedProfiles(null);
        toast.current?.show({
            severity: 'success',
            summary: 'Successo!',
            detail: 'Os Perfis de utilizadores selecionados foram eliminados com sucesso!',
            life: 3000
        }); 
    };

    
    const onInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, description: string) => {
        const val = (e.target && e.target.value) || '';
        let _profile = { ...profile };
        _profile[`${description}`] = val;

        setProfile(_profile);
    };

    // Modal de confirmação de exclusão de utilizador.
    const leftToolbarTemplate = () => {
        return (
            <React.Fragment>
                <div className="my-2">
                    <Button label="Novo" icon="pi pi-plus" severity="success" className=" mr-2" onClick={openNew} />
                    <Button label="Apagar" icon="pi pi-trash" severity="danger" onClick={confirmDeleteSelected} disabled={!selectedProfiles || !(selectedProfiles as any).length} />
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

    const idBodyTemplate = (rowData: Project.Profile) => {
        return (
            <>
                <span className="p-column-title">Código</span>
                {rowData.id}
            </>
        );
    };

    const nameBodyTemplate = (rowData: Project.Profile) => {
        return (
            <>
                <span className="p-column-title">Descrição</span>
                {rowData.description}
            </>
        );
    };

    const actionBodyTemplate = (rowData: Project.Profile) => {
        return (
            <>
                <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={() => editProfile(rowData)} />
                <Button icon="pi pi-trash" rounded severity="warning" onClick={() => confirmDeleteProfile(rowData)} />
            </>
        );
    };

    const keyNameBodyTemplate = (rowData: Project.Profile) => {
        return (
            <>
                <span className="p-column-title">Chave</span>
                {rowData.key}
            </>
        );
    };

    const header = (
        <div className="flex flex-column md:flex-row md:justify-content-between md:align-items-center">
            <h5 className="m-0">Gestão de Perfil de Utilizador</h5>
            <span className="block mt-2 md:mt-0 p-input-icon-left">
                <i className="pi pi-search" />
                <InputText type="search" onInput={(e) => setGlobalFilter(e.currentTarget.value)} placeholder="Buscar..." />
            </span>
        </div>
    );
    
    // Modal de confirmação de salvar perfil.
    const profileDialogFooter = (
        <>
            <Button label="Cancelar" icon="pi pi-times" text onClick={hideDialog} />
            <Button label="Guardar" icon="pi pi-check" text onClick={saveProfile} />
        </>
    );

    // Modal de confirmação de exclusão de perfil.
    const deleteProfileDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteProfileDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteProfile} />
        </>
    );

    // Modal de confirmação de exclusão de perfil.
    const deleteProfilesDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteProfilesDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteSelectedProfiles} />
        </>
    );

    // Retorna o componente do modal de perfil.
    return (
        <div className="grid crud-demo">
            <div className="col-12">
                <div className="card">
                    <Toast ref={toast} />
                    <Toolbar className="mb-4" left={leftToolbarTemplate} right={rightToolbarTemplate}></Toolbar>

                    <DataTable
                        ref={dt}
                        value={profiles}
                        selection={selectedProfiles}
                        onSelectionChange={(e) => setSelectedProfiles(e.value as any)}
                        dataKey="id"
                        paginator
                        rows={10}
                        rowsPerPageOptions={[5, 10, 25]}
                        className="datatable-responsive"
                        paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
                        currentPageReportTemplate="Mostra {first} a {last} de {totalRecords} Perfis de utilizadores"
                        globalFilter={globalFilter}
                        emptyMessage="Nenhum utilizador encontrado."
                        header={header}
                        responsiveLayout="scroll">
                        <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}></Column>
                        <Column field="id" header="Código" sortable body={idBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column field="description" header="Nome" sortable body={nameBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column field="key" header="Chave" sortable body={keyNameBodyTemplate} headerStyle={{ minWidth: '15rem'}}></Column>
                       {/*  <Column field="email" header="Email" sortable body={emailBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column> */}
                        <Column body={actionBodyTemplate} headerStyle={{ minWidth: '10rem' }}></Column>
                    </DataTable>

                    <Dialog visible={profileDialog} style={{ width: '450px' }} header="Detalhes do Recurso" modal className="p-fluid" footer={profileDialogFooter} onHide={hideDialog}>
                        <div className="field">
                            <label htmlFor="description">Nome</label>
                            <InputText
                                id="description"
                                value={profile.description}
                                onChange={(e) => onInputChange(e, 'description')}
                                required
                                autoFocus
                                className={classNames({
                                    'p-invalid': submitted && !profile.description
                                })}
                            />
                            {submitted && !profile.description && <small className="p-invalid">O Nome é obrigatório.</small>}
                        </div>                    

                        <div className="field">
                            <label htmlFor="key">Chave</label>
                            <InputText
                                id="key"
                                value={profile.key}
                                onChange={(e) => onInputChange(e, 'key')}
                                required
                                autoFocus
                                className={classNames({
                                    'p-invalid': submitted && !profile.key
                                })}
                            />
                            {submitted && !profile.key && <small className="p-invalid">A Chave é obrigatória.</small>}
                        </div>                        
                    </Dialog>

                    <Dialog visible={deleteProfileDialog} style={{ width: '450px' }} header="Confirmar" modal footer={deleteProfileDialogFooter} onHide={hideDeleteProfileDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {profile && (
                                <span>
                                    Você tem a certeza que pretende eliminar o recurso <b>{profile.description}</b>?
                                </span>
                            )}
                        </div>
                    </Dialog>

                    <Dialog visible={deleteProfilesDialog} style={{ width: '450px' }} header="Confirmar" modal footer={deleteProfilesDialogFooter} onHide={hideDeleteProfilesDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {profile && <span>Você tem a certeza que pretende eliminar os recursos selecionados?</span>}
                        </div>
                    </Dialog>
                </div>
            </div>
        </div>
    );
};

export default CrudProfile;
