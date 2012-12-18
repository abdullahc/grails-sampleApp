package com.xlnc.agile



import org.junit.*
import grails.test.mixin.*

@TestFor(PersonAuthorityController)
@Mock(PersonAuthority)
class PersonAuthorityControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/personAuthority/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.personAuthorityInstanceList.size() == 0
        assert model.personAuthorityInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.personAuthorityInstance != null
    }

    void testSave() {
        controller.save()

        assert model.personAuthorityInstance != null
        assert view == '/personAuthority/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/personAuthority/show/1'
        assert controller.flash.message != null
        assert PersonAuthority.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/personAuthority/list'

        populateValidParams(params)
        def personAuthority = new PersonAuthority(params)

        assert personAuthority.save() != null

        params.id = personAuthority.id

        def model = controller.show()

        assert model.personAuthorityInstance == personAuthority
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/personAuthority/list'

        populateValidParams(params)
        def personAuthority = new PersonAuthority(params)

        assert personAuthority.save() != null

        params.id = personAuthority.id

        def model = controller.edit()

        assert model.personAuthorityInstance == personAuthority
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/personAuthority/list'

        response.reset()

        populateValidParams(params)
        def personAuthority = new PersonAuthority(params)

        assert personAuthority.save() != null

        // test invalid parameters in update
        params.id = personAuthority.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/personAuthority/edit"
        assert model.personAuthorityInstance != null

        personAuthority.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/personAuthority/show/$personAuthority.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        personAuthority.clearErrors()

        populateValidParams(params)
        params.id = personAuthority.id
        params.version = -1
        controller.update()

        assert view == "/personAuthority/edit"
        assert model.personAuthorityInstance != null
        assert model.personAuthorityInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/personAuthority/list'

        response.reset()

        populateValidParams(params)
        def personAuthority = new PersonAuthority(params)

        assert personAuthority.save() != null
        assert PersonAuthority.count() == 1

        params.id = personAuthority.id

        controller.delete()

        assert PersonAuthority.count() == 0
        assert PersonAuthority.get(personAuthority.id) == null
        assert response.redirectedUrl == '/personAuthority/list'
    }
}
