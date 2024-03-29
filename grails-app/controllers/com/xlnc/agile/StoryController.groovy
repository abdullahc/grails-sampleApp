package com.xlnc.agile
import org.springframework.dao.DataIntegrityViolationException

class StoryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [storyInstanceList: Story.list(params), storyInstanceTotal: Story.count()]
    }

    def create() {
        [storyInstance: new Story(params)]
    }

    def save() {
        def storyInstance = new Story(params)
        if (!storyInstance.save(flush: true)) {
            render(view: "create", model: [storyInstance: storyInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'story.label', default: 'Story'), storyInstance.id])
        redirect(action: "show", id: storyInstance.id)
    }

    def show(Long id) {
        def storyInstance = Story.get(id)
        if (!storyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'story.label', default: 'Story'), id])
            redirect(action: "list")
            return
        }

        [storyInstance: storyInstance]
    }

    def edit(Long id) {
        def storyInstance = Story.get(id)
        if (!storyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'story.label', default: 'Story'), id])
            redirect(action: "list")
            return
        }

        [storyInstance: storyInstance]
    }

    def update(Long id, Long version) {
        def storyInstance = Story.get(id)
        if (!storyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'story.label', default: 'Story'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (storyInstance.version > version) {
                storyInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'story.label', default: 'Story')] as Object[],
                          "Another user has updated this Story while you were editing")
                render(view: "edit", model: [storyInstance: storyInstance])
                return
            }
        }

        storyInstance.properties = params

        if (!storyInstance.save(flush: true)) {
            render(view: "edit", model: [storyInstance: storyInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'story.label', default: 'Story'), storyInstance.id])
        redirect(action: "show", id: storyInstance.id)
    }

    def delete(Long id) {
        def storyInstance = Story.get(id)
        if (!storyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'story.label', default: 'Story'), id])
            redirect(action: "list")
            return
        }

        try {
            storyInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'story.label', default: 'Story'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'story.label', default: 'Story'), id])
            redirect(action: "show", id: id)
        }
    }
}
