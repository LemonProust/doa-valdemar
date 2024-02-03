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
import { UserProfileService } from 'service/UserProfileService';
import { Project } from '@/types';
import { UserService } from 'service/UserService';
import { ProfileService } from 'service/ProfileService';
import { Dropdown } from 'primereact/dropdown';
import { DropdownChangeEvent } from 'primereact/dropdown';
import { DropdownChangeEvent } from 'primereact/dropdown';

// Componentes and components
const CrudUserProfile = () => {
    let emptyUserProfile: Project.UserProfile = {
        id: 0,
        user: {name:'', login:'', email:'', passwrd:''},
        profile: {description:''}
    };

    const [userProfiles, setUserProfiles] = useState<Project.UserProfile[] | null>(null);// array de perfis que pode ser nulo
    const [userProfileDialog, setUserProfileDialog] = useState(false);
    const [deleteUserProfileDialog, setDeleteUserProfileDialog] = useState(false);
    const [deleteUserProfilesDialog, setDeleteUserProfilesDialog] = useState(false);
    const [userProfile, setUserProfile] = useState<Project.UserProfile>(emptyUserProfile);
    const [selectedUserProfiles, setSelectedUserProfiles] = useState(null);
    const [submitted, setSubmitted] = useState(false);
    const [globalFilter, setGlobalFilter] = useState('');
    const toast = useRef<Toast>(null);
    const dt = useRef<DataTable<any>>(null);
    const userProfileService = useMemo(() => new UserProfileService(), []);
    const userService = useMemo(() => new UserService(), []);
    const profileService = useMemo(() => new ProfileService(), []);
    const [users, setUsers] = useState<Project.User[]>([]);
    const [profiles, setProfiles] = useState<Project.Profile[]>([]);

    // Função para carregar os perfis de utilização
    useEffect(() => {
        if(!userProfiles){ // Caso o array de perfis esteja vazio
            userProfileService.getAll()
            .then((response) => {
                console.log(response.data);
                setUserProfiles(response.data);
            })
            .catch((error) => {
                console.log(error);
                toast.current.show({ severity: 'error', summary: 'Erro!', detail: 'Erro ao carregar os perfis! ' + error.data.message });
            });

        }
    }, [userProfileService, userProfiles]);

    // Carregando os utilizadores
    useEffect(() => {
        if(userProfileDialog){
            userService.getAll()
            .then((response) => {
                setUsers(response.data);})
            .catch((error) => {
                console.log(error);
                toast.current.show({ severity: 'error', summary: 'Erro!', detail: 'Erro ao carregar os utilizador! ' + error.data.message });
            });
        
            // Carregando o Perfil de utilizadores
            profileService.getAll()
            .then((response) => { 
                setProfiles(response.data)})
                .catch((error) => {
                    console.log(error);
                    toast.current.show({ severity: 'error', summary: 'Erro!', detail: 'Erro ao carregar os perfis! ' + error.data.message });
                });
            }
    },[userProfileDialog, userService, profileService]);

    const openNew = () => {
        setUserProfile(emptyUserProfile);
        setSubmitted(false);
        setUserProfileDialog(true);
    };

    const hideDialog = () => {
        setSubmitted(false);
        setUserProfileDialog(false);
    };

    const hideDeleteUserProfileDialog = () => {
        setDeleteUserProfileDialog(false);
    };

    const hideDeleteUserProfilesDialog = () => {
        setDeleteUserProfilesDialog(false);
    };

    const saveUserProfile = () => {
        setSubmitted(true);

        // TODO: Validation
        if (!userProfile.id) {
            userProfileService.save(userProfile).then((response) => {
                console.log(response.data);
                setUserProfileDialog(false);// se o usuário foi criado, o dialogo será fechado.
                setUserProfile(emptyUserProfile); // Limpa o formulário.
                setUserProfiles(null);
                toast.current?.show({ severity: 'info', summary: 'Successo', detail: 'Utilizador criado com sucesso!' });// Se o usuário não foi criado, o toast será fechado.
            }).catch((error) => {
                console.log(error.data.message);
                toast.current.show({ severity: 'error', summary: 'Error', detail: 'Erro ao criar utilizador! ' + error.data.message });
            });
        } else {
            userProfileService.update(userProfile).then((response) => {
                console.log(response.data);
                setUserProfileDialog(false);// se o utilizador foi atualizado, o dialogo será fechado.
                setUserProfiles(null);
                toast.current?.show({ severity: 'info', summary: 'Successo', detail: 'Utilizador atualizado com sucesso!' });// Se o utilizador não foi atualizado, o toast será fechado.
            }).catch((error) => {
                console.log(error.data.message);
                toast.current.show({ severity: 'error', summary: 'Error', detail: 'Erro ao atualizar utilizador!'+ error.data.message });
            });
        }
        
    }; 

    const editUserProfile = (userProfile: Project.userProfile) => {
        setUserProfile({ ...userProfile });
        setUserProfileDialog(true);
    };

    const confirmDeleteUserProfile = (userProfile: Project.userProfile) => {
        setUserProfile(userProfile);
        setDeleteUserProfileDialog(true);
    };

    const deleteUserProfile = () => {
        if(userProfile.id){
            userProfileService.delete(userProfile.id).then((response) => { 
            setUserProfile(emptyUserProfile); // Limpa o formulário.    
            setUserProfiles(null);           
            setDeleteUserProfileDialog(false);// se o usuário foi eliminado, o dialogo será fechado.            
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
        for (let i = 0; i < (userProfiles as any)?.length; i++) {
            if ((userProfiles as any)[i].id === id) {
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
        setDeleteUserProfilesDialog(true);
    };

    // Elimina utilizadores Recursos.
    const deleteSelectedUserProfiles = () => {
        let _userProfiles = (userProfiles as any)?.filter((val: any) => !(selectedUserProfiles as any)?.includes(val));
        setUserProfiles(_userProfiles);
        setDeleteUserProfilesDialog(false);
        setSelectedUserProfiles(null);
        toast.current?.show({
            severity: 'success',
            summary: 'Successo!',
            detail: 'Os Perfis de utilizadores selecionados foram eliminados com sucesso!',
            life: 3000
        }); 
    };

    
    const onInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        // JEIO ANTIGO
        /* let _userProfile = { ...userProfile };
        _userProfile[`${users}`] = val;

        setUserProfile(_userProfile); */

        // JEITO CERTO
        setUserProfile(prevUserProfile=> {({
            ...prevUserProfile, [name]: val,
    })});
    };

    
    // Modal de confirmação de exclusão de utilizador.
    const leftToolbarTemplate = () => {
        return (
            <React.Fragment>
                <div className="my-2">
                    <Button label="Novo" icon="pi pi-plus" severity="success" className=" mr-2" onClick={openNew} />
                    <Button label="Apagar" icon="pi pi-trash" severity="danger" onClick={confirmDeleteSelected} disabled={!selectedUserProfiles || !(selectedUserProfiles as any).length} />
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

    const idBodyTemplate = (rowData: Project.UserProfile) => {
        return (
            <>
                <span className="p-column-title">Código</span>
                {rowData.id}
            </>
        );
    };

    const userDataBodyTemplate = (rowData: Project.UserProfile) => {
        return (
            <>
                <span className="p-column-title">Utilizador</span>
                {rowData.name}
            </>
        );
    };

    const actionBodyTemplate = (rowData: Project.UserProfile) => {
        return (
            <>
                <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={() => editUserProfile(rowData)} />
                <Button icon="pi pi-trash" rounded severity="warning" onClick={() => confirmDeleteUserProfile(rowData)} />
            </>
        );
    };

    const profileUserNameBodyTemplate = (rowData: Project.UserProfile) => {
        return (
            <>
                <span className="p-column-title">Perfil</span>
                {rowData.description}
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
    const userProfileDialogFooter = (
        <>
            <Button label="Cancelar" icon="pi pi-times" text onClick={hideDialog} />
            <Button label="Guardar" icon="pi pi-check" text onClick={saveUserProfile} />
        </>
    );

    // Modal de confirmação de exclusão de perfil.
    const deleteUserProfileDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteUserProfileDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteUserProfile} />
        </>
    );

    // Modal de confirmação de exclusão de perfil.
    const deleteUserProfilesDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteUserProfilesDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteSelectedUserProfiles} />
        </>
    );

     // Modal de dropdown de utilizador.
     const onSelectUserChange = (user: Project.User) => {
        let _userProfile = { ...userProfile};
        _userProfile.user = user;
        setUserProfile(_userProfile);
    }

    // Modal de dropdown de perfil.
    const onSelectProfileChange = (profile: Project.Profile) => {
        let _userProfile = { ...userProfile};
        _userProfile.profile = profile;
        setUserProfile(_userProfile);
    }

    // Retorna o componente do modal de perfil.
    return (
        <div className="grid crud-demo">
            <div className="col-12">
                <div className="card">
                    <Toast ref={toast} />
                    <Toolbar className="mb-4" left={leftToolbarTemplate} right={rightToolbarTemplate}></Toolbar>

                    <DataTable
                        ref={dt}
                        value={userProfiles}
                        selection={selectedUserProfiles}
                        onSelectionChange={(e) => setSelectedUserProfiles(e.value as any)}
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
                        <Column field="user" header="Utilizador" sortable body={userDataBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column field="profile" header="Perfil" sortable body={profileUserNameBodyTemplate} headerStyle={{ minWidth: '15rem'}}></Column>
                       {/*  <Column field="email" header="Email" sortable body={emailBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column> */}
                        <Column body={actionBodyTemplate} headerStyle={{ minWidth: '10rem' }}></Column>
                    </DataTable>

                    <Dialog visible={userProfileDialog} style={{ width: '450px' }} header="Detalhes do Recurso" modal className="p-fluid" footer={userProfileDialogFooter} onHide={hideDialog}>
                        <div className="field">
                            <label htmlFor="user">Utilizador</label>
                            <Dropdown optionLabel="name" value={userProfile.user} options={users} filter onChange={(e: DropdownChangeEvent) => onSelectUserChange(e.value)} placeholder = 'Seleciona um perfil...'/>
        
                            {submitted && !userProfile.user && <small className="p-invalid">O Utilizador é obrigatório.</small>}
                        </div>                    

                        <div className="field">
                            <label htmlFor="profile">Perfil</label>
                            
                            <Dropdown optionLabel="description" value={userProfile.profile} options={profiles} filter onChange={(e: DropdownChangeEvent) => onSelectProfileChange(e.value)} placeholder = 'Seleciona um perfil...'/>
                            {submitted && !userProfile.profile && <small className="p-invalid">A Chave é obrigatória.</small>}
                        </div>                        
                    </Dialog>

                    <Dialog visible={deleteUserProfileDialog} style={{ width: '450px' }} header="Confirmar" modal footer={deleteUserProfileDialogFooter} onHide={hideDeleteUserProfileDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {userProfile && (
                                <span>
                                    Você tem a certeza que pretende eliminar o recurso <b>{userProfile.users}</b>?
                                </span>
                            )}
                        </div>
                    </Dialog>

                    <Dialog visible={deleteUserProfilesDialog} style={{ width: '450px' }} header="Confirmar" modal footer={deleteUserProfilesDialogFooter} onHide={hideDeleteUserProfilesDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {userProfile && <span>Você tem a certeza que pretende eliminar os recursos selecionados?</span>}
                        </div>
                    </Dialog>
                </div>
            </div>
        </div>
    );
};

export default CrudUserProfile;
